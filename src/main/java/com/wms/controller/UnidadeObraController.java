package com.wms.controller;

import java.util.Collection;

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
	
	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	public UnidadeObra buscar(@PathVariable Integer id) {
		return this.unidadeObraService.buscarUnidadeObra(id);
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.PUT)
	public UnidadeObra inserirUnidade(@RequestBody UnidadeObra unidadeObra) {
		return unidadeObraService.salvar(unidadeObra);
	}		
	
	@RequestMapping(value = "/listar_por_obra/{id}", method = RequestMethod.GET)
	public Collection<UnidadeObra> listarUnidadesPorObra(@PathVariable Integer id) {
		return unidadeObraService.listarPorObra(id);
	}
	
	@RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
	public void removerUnidade(@PathVariable Integer id) {
		unidadeObraService.remover(id);
	}
	
}
