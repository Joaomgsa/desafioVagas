package br.com.elatrampa.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import java.io.Serializable;
import java.util.Objects;

import org.dozer.Mapping;
import org.springframework.hateoas.RepresentationModel;

@JsonPropertyOrder({ "candidaturaId", "vagaId", "pessoaId"})
public class CandidaturasVo extends RepresentationModel<CandidaturasVo> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Mapping("candidaturaId")
	@JsonProperty("candidaturaId")
	private Long candidaturaKey;
	private Long vagaId;
	private Long pessoaId;
	
	public CandidaturasVo() {
		
	}

	public Long getCandidaturaKey() {
		return candidaturaKey;
	}

	public void setCandidaturaKey(Long candidaturaKey) {
		this.candidaturaKey = candidaturaKey;
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(candidaturaKey, pessoaId, vagaId);
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
		CandidaturasVo other = (CandidaturasVo) obj;
		return Objects.equals(candidaturaKey, other.candidaturaKey) && Objects.equals(pessoaId, other.pessoaId)
				&& Objects.equals(vagaId, other.vagaId);
	}
	
	
}
