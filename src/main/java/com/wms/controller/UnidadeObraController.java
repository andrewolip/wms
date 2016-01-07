package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.UnidadeObra;
import com.wms.model.service.UnidadeObraService;

@RestController
@RequestMapping(value = "/unidades")
public class UnidadeObraController {

	UnidadeObraService unidadeObraService;
	
	@Autowired
	public void setUnidadeObraService(UnidadeObraService unidadeObraService) {
		this.unidadeObraService = unidadeObraService;
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public void inserirUnidade(@RequestBody UnidadeObra unidadeObra) {
		unidadeObraService.salvar(unidadeObra);
	}		
	
	@RequestMapping(value = "/listar/{id}", method = RequestMethod.GET)
	public List<UnidadeObra> listarUnidadesPorObra(@PathVariable Integer id) {
		return unidadeObraService.listarPorObra(id);
	}
	
	@RequestMapping(value = "/apagar/{id}", method = RequestMethod.DELETE)
	public void removerUnidade(@PathVariable Integer id) {
		unidadeObraService.remover(id);
	}
	
	
}
