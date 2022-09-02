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
@Entity(name="Vaga")

public class VagasModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vagaId;
	
	private Integer experienciaVaga;
	
	private String localidadeVaga;
	
	private String profissao;
	
	private String empresa;
	
	private String descricaoVaga;
	
	private String tituloVaga;

}
