package com.wms.model.service;

import java.util.Collection;

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
 
	public ContaPagar salvar(ContaPagar contaPagar) {
		this.contaPagarRepository.save(contaPagar);
		return contaPagar;
	}
	
	public void remover(Integer id) {
		contaPagarRepository.delete(id);
	}
	
	public Collection<ContaPagar> listarContasPagar() {
		return (Collection<ContaPagar>) contaPagarRepository.findAll();
	}
	
	public ContaPagar getContaPagar(Integer id) {
		return contaPagarRepository.findOne(id);
	}

	public ContaPagar buscarContaPagar(Integer id) {
		return contaPagarRepository.findOne(id);
	}
	
	public ContaPagar buscarContaPagarPorNotaFiscal(Long notaFiscal) {
		ContaPagar c = contaPagarRepository.findByNotaFiscal(notaFiscal);
		return c;
	}
	
	public Collection<ContaPagar> listarPorObra(Obra obra) {
		return this.contaPagarRepository.findByObra(obra);
	}
	
	public Collection<ContaPagar> listarPorUnidade(UnidadeObra unidadeObra) {
		return this.contaPagarRepository.findByUnidadeObra(unidadeObra);
	}

	public Collection<ContaPagar> listarContasNaoPagas(Integer id) {
		return contaPagarRepository.listarContasNaoPagas(id);
	}
	
	
}
