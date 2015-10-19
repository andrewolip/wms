package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.wms.model.entity.Funcao;
import com.wms.model.repository.FuncaoRepository;

@RestController
@RequestMapping(value = "/funcao")
public class FuncaoController {

	@Autowired
	private FuncaoRepository funcaoRepository;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void inserir(@RequestBody Funcao funcao) {
		funcaoRepository.save(funcao);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Funcao create(@RequestBody Funcao funcao) {
		return funcaoRepository.save(funcao);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void atualizar(@RequestBody Funcao funcao) {

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete() {

	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<Funcao> findAll() {
		return (List<Funcao>) funcaoRepository.findAll();
	}

}	