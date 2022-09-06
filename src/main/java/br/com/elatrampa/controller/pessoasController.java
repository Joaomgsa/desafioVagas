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

import br.com.elatrampa.model.PessoasModel;
import br.com.elatrampa.repository.PessoasRepository;

@RestController
@RequestMapping({"/pessoas"})
public class PessoasController {
	
	private PessoasRepository repository;
	
	PessoasController(PessoasRepository pessoasRepository) {
		this.repository = pessoasRepository;
	}

	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public PessoasModel create(@RequestBody PessoasModel pessoa) {
		return repository.save(pessoa);
	}
	
	@DeleteMapping(path={"/{pessoaid}"})
	public ResponseEntity<?> delete(@PathVariable("pessoaid") long pessoaid){
		return repository.findById(pessoaid)
				.map(record ->{
					repository.deleteById(pessoaid);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
	}
	

	
}
