package br.com.elatrampa.model;

import java.util.Date;
import java.util.Objects;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="Candidatura")
public class CandidaturasModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidaturaId;
	
	@Column(name= "vagaId")
	private Long vagaId;
	
	@Column(name= "pessoaId")
	private Long pessoaId;
	
	public CandidaturasModel() {
	}

	public Long getCandidaturaId() {
		return candidaturaId;
	}

	public void setCandidaturaId(Long candidaturaId) {
		this.candidaturaId = candidaturaId;
	}

	public Long getVagaId() {
		return vagaId;
	}

	public void setVagaId(Long vagaId) {
		this.vagaId = vagaId;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(candidaturaId, pessoaId, vagaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidaturasModel other = (CandidaturasModel) obj;
		return Objects.equals(candidaturaId, other.candidaturaId) && Objects.equals(pessoaId, other.pessoaId)
				&& Objects.equals(vagaId, other.vagaId);
	}
	
	
	
	
}
