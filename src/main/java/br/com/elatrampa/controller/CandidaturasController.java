package br.com.elatrampa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elatrampa.repository.CandidaturasRepository;

@RestController
@RequestMapping({"/candidaturas"})
public class CandidaturasController {
	
	private CandidaturasRepository repository;
	
	CandidaturasController(CandidaturasRepository candidaturasRepository){
		this.repository = candidaturasRepository;
	}
	
	
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}
	
}
