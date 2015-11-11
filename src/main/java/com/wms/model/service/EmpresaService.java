package com.wms.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.Empresa;
import com.wms.model.entity.Funcao;
import com.wms.model.repository.EmpresaRepository;
import com.wms.model.repository.FuncaoRepository;

import scala.annotation.meta.setter;

@Service
public class EmpresaService {
	
	private EmpresaRepository empresaRepository;
	
	@Autowired
    public void setEmpresaRepository(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
 
	public void salvar(Empresa empresa) {
		empresaRepository.save(empresa);
	}
	
	public void remover(Integer id) {
		empresaRepository.delete(id);
	}
	
	public List<Empresa> listarEmpresas() {
		return (List<Empresa>) empresaRepository.findAll();
	}
	
	public Empresa getEmpresa(Integer id) {
		return empresaRepository.findOne(id);
	}
	
}
