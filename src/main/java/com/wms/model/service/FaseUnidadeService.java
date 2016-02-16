package com.wms.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.FaseUnidade;
import com.wms.model.repository.FaseUnidadeRepository;

@Service
public class FaseUnidadeService {

	private FaseUnidadeRepository faseUnidadeRepository;
	
	@Autowired
	public void setFaseUnidadeRepository(
			FaseUnidadeRepository faseUnidadeRepository) {
		this.faseUnidadeRepository = faseUnidadeRepository;
	}
	
	public void salvar(FaseUnidade faseUnidade) {
		this.faseUnidadeRepository.save(faseUnidade);
	}
	
	public void remover(FaseUnidade faseUnidade) {
		this.faseUnidadeRepository.delete(faseUnidade);
	}
	
	public Collection<FaseUnidade> listarFases() {
		return (List<FaseUnidade>) this.faseUnidadeRepository.findAll();
	}
	
	public Collection<FaseUnidade> listarFasesPorUnidade(Integer id) {
		return this.faseUnidadeRepository.findByUnidadeObraIdUnidadeObra(id);
	}
	
	public void salvarLista(List<FaseUnidade> fases) {
		this.faseUnidadeRepository.save(fases);
	}
	
}
