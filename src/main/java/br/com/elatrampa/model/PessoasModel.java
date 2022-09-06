package br.com.elatrampa.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="Pessoa")
public class PessoasModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pessoaID;
	
	private String nomePessoa;
	
	private String profissaoPessoa;
	
	private String localizacaoPessoa;
	
	private String nivelExperienciaPessoa;
}