package br.com.elatrampa.controller;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import br.com.elatrampa.services.PessoasService;
import br.com.elatrampa.vo.PessoaVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name ="Pessoas Endpoint")
@RestController
@RequestMapping({"/pessoas"})
public class PessoasController {
	
	@Autowired
	private PessoasService service;

	@Operation(summary = "Encontrar todas as pessoas cadastradas")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<CollectionModel<PessoaVo>> findAll(
			@RequestParam(value="page", defaultValue = "0") int page,
			@RequestParam(value="limit", defaultValue ="12") int limit,
			@RequestParam(value="direction", defaultValue = "asc") String direction) {
			
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "Nome"));
		
		Page<PessoaVo> pessoa = service.findAll(pageable);
		pessoa
			.stream()
			.forEach(p -> p.add(
					linkTo(methodOn(PessoasController.class).findById(p.getKey())).withSelfRel()
					)
				);
		return ResponseEntity.ok(CollectionModel.of(pessoa));
				
	}
	
	@Operation(summary = "Encontrar uma pessoa pelo ID")
	@GetMapping(value = "{id}", produces= { "application/json", "application/xml", "application/x-yaml" })
	public PessoaVo findById(@PathVariable("id") Long id) {
		PessoaVo pessoaVo = service.findById(id);
		pessoaVo.add(linkTo(methodOn(PessoasController.class).findById(id)).withSelfRel());
		
		return pessoaVo;
	}
	
	
	@Operation(summary = "Cadastrar uma nova Pessoa")
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
	consumes = { "application/json", "application/xml", "application/x-yaml" })
	public PessoaVo create(@RequestBody PessoaVo pessoa) {
		PessoaVo pessoaVo = service.create(pessoa);
		pessoaVo.add(linkTo(methodOn(PessoasController.class).findById(pessoaVo.getKey())).withSelfRel());
		return pessoaVo;
	}
	
	@Operation(summary = "Atualizar uma pessoa especifica")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
	consumes = { "application/json", "application/xml", "application/x-yaml" })
	public PessoaVo update(@RequestBody PessoaVo pessoa) {
		PessoaVo pessoaVo = service.update(pessoa);
		pessoaVo.add(linkTo(methodOn(PessoasController.class).findById(pessoaVo.getKey())).withSelfRel());
		return pessoaVo;
	}
	
	
	
	@Operation(summary = "Apagando o registro de uma pessoa pelo seu ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
		
}
