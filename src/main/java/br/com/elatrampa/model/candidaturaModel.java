package br.com.elatrampa.model;

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
@Entity(name="Candidatura")
public class candidaturaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candidaturaId;
	
	private Integer idCanditato;
	
	private Integer idVaga;
}
