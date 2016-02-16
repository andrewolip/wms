package com.wms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.Colaborador;
import com.wms.model.service.ColaboradorService;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorController {

	private ColaboradorService colaboradorService;
	
	@Autowired
	public void setColaboradorService(ColaboradorService colaboradorService) {
		this.colaboradorService = colaboradorService;
	}

/*	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public void inserir(@RequestBody Colaborador colaborador) {
		colaboradorService.salvar(colaborador);
	} */

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Colaborador colaborador) {
		colaboradorService.salvar(colaborador);
	}

	@RequestMapping(value = "/apagar/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody Colaborador colaborador) {
		colaboradorService.remover(colaborador.getIdFuncionario());
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public Collection<Colaborador> findAll() {
		return colaboradorService.listarColaboradores();
	}

}
