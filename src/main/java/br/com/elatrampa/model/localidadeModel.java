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
@Entity(name="Localidade")
public class localidadeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer localidadeId;
	
	private String localidade;
	
	private Integer distancia;

}
