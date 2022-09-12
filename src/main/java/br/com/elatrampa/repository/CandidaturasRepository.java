package br.com.elatrampa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.elatrampa.model.CandidaturasModel;

public interface CandidaturasRepository extends JpaRepository <CandidaturasModel, Long>{

	
	@Query("select c from candidaturas c where c.candidatura = :candidatura")
	public List<CandidaturasModel> rankingCandidaturas(
			@Param("candidatura") CandidaturasModel candidaturaId);
}
