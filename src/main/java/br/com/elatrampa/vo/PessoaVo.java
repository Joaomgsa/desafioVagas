package br.com.elatrampa.vo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import org.dozer.Mapping;

@JsonPropertyOrder({"pessoa_Id", "nomePessoa", "profissaoPessoa", "localizacaoPessoa", "nivelExperienciaPessoa"})
public class PessoaVo extends RepresentationModel<PessoaVo> implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	@Mapping("pessoa_Id")
	@JsonProperty("pessoa_Id")
	private Long key;
	private String nomePessoa;
	private String profissaoPessoa;
	private String localizacaoPessoa;
	private String nivelExperienciaPessoa;
	
	public PessoaVo() {
		
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getProfissaoPessoa() {
		return profissaoPessoa;
	}

	public void setProfissaoPessoa(String profissaoPessoa) {
		this.profissaoPessoa = profissaoPessoa;
	}

	public String getLocalizacaoPessoa() {
		return localizacaoPessoa;
	}

	public void setLocalizacaoPessoa(String localizacaoPessoa) {
		this.localizacaoPessoa = localizacaoPessoa;
	}

	public String getNivelExperienciaPessoa() {
		return nivelExperienciaPessoa;
	}

	public void setNivelExperienciaPessoa(String nivelExperienciaPessoa) {
		this.nivelExperienciaPessoa = nivelExperienciaPessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(key, localizacaoPessoa, nivelExperienciaPessoa, nomePessoa, profissaoPessoa);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaVo other = (PessoaVo) obj;
		return Objects.equals(key, other.key) && Objects.equals(localizacaoPessoa, other.localizacaoPessoa)
				&& Objects.equals(nivelExperienciaPessoa, other.nivelExperienciaPessoa)
				&& Objects.equals(nomePessoa, other.nomePessoa)
				&& Objects.equals(profissaoPessoa, other.profissaoPessoa);
	}
	



	
	

}
