package br.com.elatrampa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elatrampa.repository.VagasRepository;

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
	
	@GetMapping(path = {"/{vagaId}"})
	public ResponseEntity<Vagas> findByid(@PathVariable long vagaId,
			@RequestBody Vagas vagas) {
		return  repository.findById(vagas.get)
	}
}
