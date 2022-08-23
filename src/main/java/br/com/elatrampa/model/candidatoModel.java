package br.com.elatrampa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Candidato")
public class candidatoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candidatoId;
	
	private String nome;
	
	private String localidade;
	
	private String profissao;
	
	private String nivelExperiencia;
	

}
