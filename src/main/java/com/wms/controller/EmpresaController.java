package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.Empresa;
import com.wms.model.service.EmpresaService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {

	private EmpresaService empresaService;
	
	@Autowired
	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

/*	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public void inserir(@RequestBody Empresa empresa) {
		empresaService.salvar(empresa);
	} */

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Empresa empresa) {
		empresaService.salvar(empresa);
	}

	@RequestMapping(value = "/apagar/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody Empresa empresa) {
		empresaService.remover(empresa.getIdEmpresa());
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<Empresa> findAll() {
		return empresaService.listarEmpresas();
	}

}
