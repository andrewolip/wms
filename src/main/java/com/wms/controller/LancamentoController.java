package com.wms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.Lancamento;
import com.wms.model.service.LancamentoService;

@RestController
@RequestMapping(value="/lancamentos")
public class LancamentoController {

	private LancamentoService lancamentoService;

	@Autowired
	public void setLancamentoService(LancamentoService lancamentoService) {
		this.lancamentoService = lancamentoService;
	}

	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public Collection<Lancamento> listarLancamentos() {
		return lancamentoService.listarLancamentos();
	}
	
	@RequestMapping(value="/listar_por_obra/{id}", method = RequestMethod.GET)
	public Collection<Lancamento> listarPorObra(@PathVariable Integer id) {
		return this.lancamentoService.listarLancamentosPorObra(id);
	}
}
	