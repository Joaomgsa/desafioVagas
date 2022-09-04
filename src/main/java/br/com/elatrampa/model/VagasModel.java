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
@Entity(name="Vagas")

public class VagasModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vagaId;
	
	private String tituloVaga;
	
	private String descricaoVaga;
		
	private String localizacaoVaga;
	
	private Integer experienciaVaga;	
	
	

}
