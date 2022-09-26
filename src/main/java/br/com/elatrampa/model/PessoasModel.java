package br.com.elatrampa.model;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



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
	
	public PessoasModel() {
		
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
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
		return Objects.hash(localizacaoPessoa, nivelExperienciaPessoa, nomePessoa, pessoaId, profissaoPessoa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoasModel other = (PessoasModel) obj;
		return Objects.equals(localizacaoPessoa, other.localizacaoPessoa)
				&& Objects.equals(nivelExperienciaPessoa, other.nivelExperienciaPessoa)
				&& Objects.equals(nomePessoa, other.nomePessoa) && Objects.equals(pessoaId, other.pessoaId)
				&& Objects.equals(profissaoPessoa, other.profissaoPessoa);
	}
	
	
}