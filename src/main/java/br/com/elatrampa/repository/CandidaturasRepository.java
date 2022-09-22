package br.com.elatrampa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.elatrampa.model.CandidaturasModel;

@Repository
public interface CandidaturasRepository extends JpaRepository <CandidaturasModel, Long>{

}
