package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.Fornecedor;
import com.wms.model.service.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorController {

	private FornecedorService fornecedorService;
	
	@Autowired
	public void setFornecedorService(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	public Fornecedor buscar(@RequestBody Fornecedor fornecedor) {
		return this.fornecedorService.buscarFornecedor(fornecedor.getIdFornecedor());
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Fornecedor fornecedor) {
		fornecedorService.salvar(fornecedor);
	}

//	@RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
//	public void delete(@RequestBody Fornecedor fornecedor) {
//		fornecedorService.remover(fornecedor.getIdFornecedor());
//	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<Fornecedor> findAll() {
		return fornecedorService.listarFornecedores();
	}

}
