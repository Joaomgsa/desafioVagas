package br.com.elatrampa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elatrampa.model.vagaModel;

public interface vagasRepository extends JpaRepository<vagaModel, Integer>{

}
