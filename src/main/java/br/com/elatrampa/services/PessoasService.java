package br.com.elatrampa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.elatrampa.converter.DozerConverter;
import br.com.elatrampa.model.PessoasModel;
import br.com.elatrampa.repository.PessoasRepository;
import br.com.elatrampa.vo.PessoaVo;

@Service
public class PessoasService {
	
	@Autowired
	PessoasRepository repository;
	
	public PessoaVo create(PessoaVo pessoa) {
		var entity = DozerConverter.parseObject(pessoa, PessoasModel.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PessoaVo.class);
		return vo;
	}
	
	public Page<PessoaVo> findAll(Pageable pageable) {
		var page = repository.findAll(pageable);
		return page.map(this::convertToPessoaVo);
	}

	private PessoaVo convertToPessoaVo(PessoasModel entity) {
		return DozerConverter.parseObject(entity, PessoaVo.class);
	}
	
	public PessoaVo findById(Long pessoaId) {
		var entity = repository.findById(pessoaId)
				.orElseThrow(() -> new ResourceNotFoundException("Pessoa Não Encontrada nesse ID"));
		return DozerConverter.parseObject(entity, PessoaVo.class);
	}

}
