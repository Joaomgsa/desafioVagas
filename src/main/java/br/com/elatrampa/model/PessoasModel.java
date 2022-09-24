package br.com.elatrampa.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Pessoa")
public class PessoasModel implements Serializable{

	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pessoaId;
	
	@Column(name = "nomePessoa", nullable=false, length=180)
	private String nomePessoa;
	
	@Column(name = "profissaoPessoa", nullable=false, length=180)
	private String profissaoPessoa;
	
	@Column(name = "localizacaoPessoa", nullable=false, length=1)
	private String localizacaoPessoa;
	
	@Column(name = "nivelExperienciaPessoa", nullable=false, length=180)	
	private String nivelExperienciaPessoa;
}