package br.com.elatrampa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elatrampa.model.PessoasModel;

@Repository
public interface PessoasRepository extends JpaRepository<PessoasModel, Long> {

}
