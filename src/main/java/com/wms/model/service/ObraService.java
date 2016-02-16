package com.wms.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.Obra;
import com.wms.model.repository.ObraRepository;

@Service
public class ObraService {
	
	private ObraRepository obraRepository;
	
	@Autowired
    public void setObraRepository(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }
 
	public void salvar(Obra obra) {
		obraRepository.save(obra);
	}
	
	public void remover(Integer id) {
		obraRepository.delete(id);
	}
	
	public Collection<Obra> listarObras() {
		return (Collection<Obra>) obraRepository.findAll();
	}
	
	public Obra buscarObra(Integer id) {
		return obraRepository.findOne(id);
	}
	
}
