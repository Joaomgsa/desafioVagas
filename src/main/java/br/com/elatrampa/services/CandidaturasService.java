package br.com.elatrampa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.elatrampa.converter.DozerConverter;
import br.com.elatrampa.exception.ResourceNotFoundException;
import br.com.elatrampa.model.CandidaturasModel;
import br.com.elatrampa.repository.CandidaturasRepository;
import br.com.elatrampa.vo.CandidaturasVo;

@Service
public class CandidaturasService {

	@Autowired
	CandidaturasRepository repository;
	
	public CandidaturasVo create(CandidaturasVo candidaturas) {
		var entity = DozerConverter.parseObject(candidaturas, CandidaturasModel.class);
		var vo = DozerConverter.parseObject(repository.save(entity), CandidaturasVo.class);
		return vo;
	}
	
	public Page<CandidaturasVo> findAll(Pageable pageable){
		var page = repository.findAll(pageable);
		return page.map(this::convertToCandidaturasVO);
	}
	
	private CandidaturasVo convertToCandidaturasVO(CandidaturasModel entity) {
		return DozerConverter.parseObject(entity, CandidaturasVo.class);
	}
	
	public CandidaturasVo findById(Long vagasId) {
		var entity = repository.findById(vagasId)
				.orElseThrow(()-> new ResourceNotFoundException("Registro não encontrado para esse ID"));
		return DozerConverter.parseObject(entity, CandidaturasVo.class);
	}
	
	public CandidaturasVo update(CandidaturasVo candidatura) {
		var entity = repository.findById(candidatura.getCandidaturaKey())
				.orElseThrow(()-> new ResourceNotFoundException("Registro não encontrado para esse ID"));
		entity.setVagaId(candidatura.getVagaId());
		entity.setPessoaId(candidatura.getPessoaId());
		
		var vo = DozerConverter.parseObject(repository.save(entity), CandidaturasVo.class);
		
		return vo;
	}
	
	public void delete(Long candidaturaId) {
		CandidaturasModel entity = repository.findById(candidaturaId)
				.orElseThrow(()-> new ResourceNotFoundException("Registro não encontrado para esse ID"));
		repository.delete(entity);
	}
}
