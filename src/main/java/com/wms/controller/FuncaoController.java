package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.Funcao;
import com.wms.model.service.FuncaoService;

@RestController
@RequestMapping(value = "/funcoes")
public class FuncaoController {

	private FuncaoService funcaoService;
	
	@Autowired
	public void setFuncaoService(FuncaoService funcaoService) {
		this.funcaoService = funcaoService;
	}

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public void inserir(@RequestBody Funcao funcao) {
		funcaoService.salvar(funcao);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void atualizar(@RequestBody Funcao funcao) {

	}

	@RequestMapping(value = "/apagar/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody Funcao funcao) {
		funcaoService.remover(funcao.getIdFuncao());
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<Funcao> findAll() {
		return funcaoService.listarFuncoes();
	}

}
