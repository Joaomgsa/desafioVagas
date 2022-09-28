package br.com.elatrampa.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

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

import br.com.elatrampa.repository.VagasRepository;
import br.com.elatrampa.services.VagasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import br.com.elatrampa.vo.VagasVo;


@Tag(name= "Vagas Endpoint")
@RestController
@RequestMapping({"/vagas"})
public class VagasController {

	@Autowired
	private VagasService service;
	
	@Operation(summary = "Listar todas as vagas")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<CollectionModel<VagasVo>> findAll(
			@RequestParam(value="page", defaultValue = "0") int page,
			@RequestParam(value="limit", defaultValue = "12") int limit,
			@RequestParam(value="direction", defaultValue = "asc") String direction) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC; 
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "tituloVaga"));
		
		Page<VagasVo> vagas = service.findAll(pageable);
		vagas
			.stream()
			.forEach(p -> p.add(
					linkTo(methodOn(VagasController.class).findById(p.getVagaKey())).withSelfRel()
					)
			);
	
		return ResponseEntity.ok(CollectionModel.of(vagas));
	}
	
	@Operation(summary = "Encontrar uma vaga pelo ID" )
	@GetMapping(value = "/{vagaId}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public VagasVo findById(@PathVariable("vagaId") Long vagaId) {
		VagasVo vagasVo = service.findById(vagaId);
		vagasVo.add(linkTo(methodOn(VagasController.class).findById(vagaId)).withSelfRel());
		return vagasVo;
	}	
	
	@Operation(summary = "Adicionar uma nova Vaga") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public VagasVo create(@RequestBody VagasVo vaga) {
		VagasVo vagasVo = service.create(vaga);
		vagasVo.add(linkTo(methodOn(VagasController.class).findById(vagasVo.getVagaKey())).withSelfRel());
		return vagasVo;
	}
	
	@Operation(summary = "Update uma vaga especifica")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public VagasVo update(@RequestBody VagasVo vaga) {
		VagasVo vagasVo = service.update(vaga);
		vagasVo.add(linkTo(methodOn(VagasController.class).findById(vagasVo.getVagaKey())).withSelfRel());
		return vagasVo;
	}
	
	@Operation(summary = "Apagar uma vaga especifica pelo ID")
	@DeleteMapping("/{vagaId}")
	public ResponseEntity<?> delete(@PathVariable("vagaId") Long vagaId) {
		service.delete(vagaId);
		return ResponseEntity.ok().build();
	}	
	
	
	
		
}
