package com.wms.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.Funcao;
import com.wms.model.repository.FuncaoRepository;

@Service
public class FuncaoService {
	
	private FuncaoRepository funcaoRepository;
	
	@Autowired
    public void setFuncaoRepository(FuncaoRepository funcaoRepository) {
        this.funcaoRepository = funcaoRepository;
    }
 
	public void salvar(Funcao funcao) {
		funcaoRepository.save(funcao);
	}
	
	public void remover(Integer id) {
		funcaoRepository.delete(id);
	}
	
	public List<Funcao> listarFuncoes() {
		return (List<Funcao>) funcaoRepository.findAll();
	}
	
	public Funcao getFuncao(Integer id) {
		return funcaoRepository.findOne(id);
	}
	
}
