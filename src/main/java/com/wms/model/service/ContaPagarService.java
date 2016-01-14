package com.wms.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.ContaPagar;
import com.wms.model.entity.Obra;
import com.wms.model.entity.UnidadeObra;
import com.wms.model.repository.ContaPagarRepository;

@Service
public class ContaPagarService {
	
	private ContaPagarRepository contaPagarRepository;
	
	@Autowired
    public void setContaPagarRepository(ContaPagarRepository contaPagarRepository) {
        this.contaPagarRepository = contaPagarRepository;
    }
 
	public void salvar(ContaPagar contaPagar) {
		contaPagarRepository.save(contaPagar);
	}
	
	public void remover(Integer id) {
		contaPagarRepository.delete(id);
	}
	
	public List<ContaPagar> listarContasPagar() {
		return (List<ContaPagar>) contaPagarRepository.findAll();
	}
	
	public ContaPagar getContaPagar(Integer id) {
		return contaPagarRepository.findOne(id);
	}

	public ContaPagar buscarContaPagar(Integer id) {
		return contaPagarRepository.findOne(id);
	}
	
	public List<ContaPagar> listarPorObra(Obra obra) {
		return this.contaPagarRepository.findByObra(obra);
	}
	
	public List<ContaPagar> listarPorUnidade(UnidadeObra unidadeObra) {
		return this.contaPagarRepository.findByUnidadeObra(unidadeObra);
	}
}
