package com.wms.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.Conta;
import com.wms.model.entity.UnidadeObra;
import com.wms.model.repository.UnidadeObraRepository;

@Service
public class UnidadeObraService {

	private UnidadeObraRepository unidadeObraRepository;
	
	@Autowired
	public void setUnidadeObraRepository(UnidadeObraRepository unidadeObraRepository) {
		this.unidadeObraRepository = unidadeObraRepository;
	}
	
	public UnidadeObra salvar(UnidadeObra unidadeObra) {
		this.unidadeObraRepository.save(unidadeObra);
		return unidadeObra;
	}
	
	public void salvarLista(List<UnidadeObra> fases) {
		this.unidadeObraRepository.save(fases);
	}
	
	public void remover(Integer id) {
		this.unidadeObraRepository.delete(id);
	}
	
	public UnidadeObra buscarUnidade(Integer id) {
		return this.unidadeObraRepository.findOne(id);
	}
	
	public Collection<UnidadeObra> listarUnidades() {
		return (Collection<UnidadeObra>) this.unidadeObraRepository.findAll();
	}
	
	public Collection<UnidadeObra> listarPorObra(Integer id) {
		return this.unidadeObraRepository.findByObraIdObra(id);
	}
	
	public UnidadeObra buscarUnidadeObra(Integer id) {
		return unidadeObraRepository.findOne(id);
	}
	
	public void realizarLancamento(Conta conta) {
		
	}
	
}
