package com.wms.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.Lancamento;
import com.wms.model.repository.LancamentoRepository;

@Service
public class LancamentoService {

	private LancamentoRepository lancamentoRepository;

	@Autowired
	public void setRepository(LancamentoRepository lancamentoRepository) {
		this.lancamentoRepository = lancamentoRepository;
	}

	public void salvar(Lancamento lancamento) {
		lancamentoRepository.save(lancamento);
	}

	public void remover(Integer id) {
		lancamentoRepository.delete(id);
	}

	public Collection<Lancamento> listarLancamentos() {
		return lancamentoRepository.findAll();
	}
	
	public Collection<Lancamento> listarLancamentosPorObra(Integer id) {
		return lancamentoRepository.listarLancamentosPorObra(id);
	}

}
