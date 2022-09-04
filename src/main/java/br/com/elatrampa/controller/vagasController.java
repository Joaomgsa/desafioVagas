package br.com.elatrampa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elatrampa.repository.VagasRepository;
import br.com.elatrampa.model.VagasModel;

@RestController
@RequestMapping({"/vagas"})
public class VagasController {

	private VagasRepository repository;
	
	VagasController(VagasRepository vagasrepository) {
		this.repository = vagasrepository;
	}
	
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public VagasModel create(@RequestBody VagasModel vagas) {
		return repository.save(vagas);
	}
	
	@DeleteMapping(path = {"/{vagaId}"})
	public ResponseEntity<?> delete(@PathVariable("vagaId") long vagaId) {
		return repository.findById(vagaId)
				.map(record ->{
					repository.deleteById(vagaId);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
	}
	
}
