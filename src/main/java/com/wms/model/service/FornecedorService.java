package com.wms.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.Fornecedor;
import com.wms.model.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
    public void setFuncaoRepository(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }
 
	public void salvar(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
	}
	
	public void remover(Integer id) {
		fornecedorRepository.delete(id);
	}
	
	public List<Fornecedor> listarFornecedores() {
		return (List<Fornecedor>) fornecedorRepository.findAll();
	}
	
	public Fornecedor getFornecedor(Integer id) {
		return fornecedorRepository.findOne(id);
	}

	public Fornecedor buscarFornecedor(Integer id) {
		return fornecedorRepository.findOne(id);
	}
	
}
