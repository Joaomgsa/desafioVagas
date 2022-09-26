package br.com.elatrampa.services;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.elatrampa.converter.DozerConverter;
import br.com.elatrampa.model.VagasModel;
import br.com.elatrampa.repository.VagasRepository;
import br.com.elatrampa.vo.VagasVo;
import br.com.elatrampa.exception.ResourceNotFoundException;

@Service
public class VagasService {

	@Autowired
	VagasRepository repository;
	
	public VagasVo create(VagasVo vagas) {
		var entity = DozerConverter.parseObject(vagas, VagasModel.class);
		var vo = DozerConverter.parseObject(repository.save(entity), VagasVo.class);
		return vo;
	}
	
	public Page<VagasVo> findAll(Pageable pageable) {
		var page = repository.findAll(pageable);
		return page.map(this::convertToVagasVo);
	}
	private VagasVo convertToVagasVo(VagasModel entity) {
		return DozerConverter.parseObject(entity, VagasVo.class);
	}
	
	public VagasVo findById(Long vagasId) {
		var entity = repository.findById(vagasId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados registros com esse ID"));
		return DozerConverter.parseObject(entity, VagasVo.class);
	}
	
	public VagasVo update(VagasVo vaga) {
		var entity = repository.findById(vaga.getVagaKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados registros com esse ID"));
		entity.setTituloVaga(vaga.getTituloVaga());
		entity.setDescricaoVaga(vaga.getDescricaoVaga());
		entity.setEmpresa(vaga.getEmpresa());
		entity.setLocalizacaoVaga(vaga.getLocalizacaoVaga());
		entity.setExperienciaVaga(vaga.getExperienciaVaga());		
		
		var vo = DozerConverter.parseObject(repository.save(entity), VagasVo.class);
		return vo;
	}
	
	public void delete(Long vagasId) {
		VagasModel entity = repository.findById(vagasId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados registros com esse ID"));
		repository.delete(entity);
	}
}
