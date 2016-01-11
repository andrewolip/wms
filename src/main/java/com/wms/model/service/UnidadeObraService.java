package com.wms.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.UnidadeObra;
import com.wms.model.repository.UnidadeObraRepository;

@Service
public class UnidadeObraService {

	private UnidadeObraRepository unidadeObraRepository;
	
	@Autowired
	public void setUnidadeObraRepository(UnidadeObraRepository unidadeObraRepository) {
		this.unidadeObraRepository = unidadeObraRepository;
	}
	
	public void salvar(UnidadeObra unidadeObra) {
		this.unidadeObraRepository.save(unidadeObra);
	}
	
	public void remover(Integer id) {
		this.unidadeObraRepository.delete(id);
	}
	
	public UnidadeObra buscarUnidade(Integer id) {
		return this.unidadeObraRepository.findOne(id);
	}
	
	public List<UnidadeObra> listarUnidades() {
		return (List<UnidadeObra>) this.unidadeObraRepository.findAll();
	}
	
	public List<UnidadeObra> listarPorObra(Integer id) {
		return this.unidadeObraRepository.findByObraIdObra(id);
	}
	
}
