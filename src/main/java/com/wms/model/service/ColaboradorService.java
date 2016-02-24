package com.wms.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.Colaborador;
import com.wms.model.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
    public void setColaboradorRepository(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }
 
	public void salvar(Colaborador colaborador) {
		colaboradorRepository.save(colaborador);
	}
	
	public void remover(Integer id) {
		colaboradorRepository.delete(id);
	}
	
	public Colaborador getColaborador(Integer id) {
		return colaboradorRepository.findOne(id);
	}

	public Collection<Colaborador> listarColaboradores() {
		return (Collection<Colaborador>) colaboradorRepository.findAll();
	}
	
	public Collection<Colaborador> listarPorObra(Integer id) {
		return this.colaboradorRepository.findByObraIdObra(id);
	}
}
