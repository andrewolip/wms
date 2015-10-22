package com.wms.model.service;

import java.util.List;

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
	
	public void delete(Obra obra) {
		obraRepository.delete(obra);
	}
	
	public List<Obra> listarObras() {
		return (List<Obra>) obraRepository.findAll();
	}
	
	public Obra getObra(Integer id) {
		return obraRepository.findOne(id);
	}
	
}
