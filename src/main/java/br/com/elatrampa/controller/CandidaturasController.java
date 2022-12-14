package br.com.elatrampa.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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


import br.com.elatrampa.services.CandidaturasService;
import br.com.elatrampa.vo.CandidaturasVo;




@Tag(name = "Candidaturas Endpoint")
@RestController
@RequestMapping({"/candidaturas"})
public class CandidaturasController {
	
	@Autowired 
	private CandidaturasService service;
	
	@Operation(summary = "Find all books" )
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<CollectionModel<CandidaturasVo>> findAll(
			@RequestParam(value="page", defaultValue ="0") int page,
			@RequestParam(value="limit", defaultValue ="12") int limit,
			@RequestParam(value="direction", defaultValue ="0") String direction) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "vagas"));
		
		Page<CandidaturasVo> candidaturas = service.findAll(pageable);
		candidaturas
			.stream()
			.forEach(p -> p.add(
					linkTo(methodOn(CandidaturasController.class).findById(p.getCandidaturaKey())).withSelfRel()
					)
				);
		return ResponseEntity.ok(CollectionModel.of(candidaturas));
		
	}
	
	@Operation(summary = "Encontrar uma candidatura especifica por ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public CandidaturasVo findById(@PathVariable("id") Long id) {
		CandidaturasVo candidaturasVo = service.findById(id);
		candidaturasVo.add(linkTo(methodOn(CandidaturasController.class).findById(id)).withSelfRel());
		return candidaturasVo;
	}	
	
	@Operation(summary = "Criar um novo livro")
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CandidaturasVo create(@RequestBody CandidaturasVo candidatura) {
		CandidaturasVo candidaturasVo = service.create(candidatura);
		candidaturasVo.add(linkTo(methodOn(CandidaturasController.class).findById(candidaturasVo.getCandidaturaKey())).withSelfRel());
		return candidaturasVo;
	}
	
	@Operation(summary = "Atualizando uma candidatura especifica")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CandidaturasVo update(@RequestBody CandidaturasVo candidatura) {
		CandidaturasVo candidaturasVo = service.update(candidatura);
		candidaturasVo.add(linkTo(methodOn(CandidaturasController.class).findById(candidaturasVo.getCandidaturaKey())).withSelfRel());
		return candidaturasVo;
	}	
	
	@Operation(summary = "Apagar uma candidatura pelo seu Id")
	@DeleteMapping("/{candidaturaKey}")
	public ResponseEntity<?> delete(@PathVariable("candidaturaKey") Long candidaturaKey) {
		service.delete(candidaturaKey);
		return ResponseEntity.ok().build();
	}
	
}
