package br.com.elatrampa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elatrampa.model.CandidaturasModel;

public interface CandidaturasRepository extends JpaRepository <CandidaturasModel, Long>{

}
