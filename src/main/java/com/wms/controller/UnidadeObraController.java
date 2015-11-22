package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.Obra;
import com.wms.model.entity.UnidadeObra;
import com.wms.model.service.UnidadeObraService;

@RestController
@RequestMapping("/unidades")
public class UnidadeObraController {

	private UnidadeObraService unidadeObraService;
	
	@Autowired
	public void setUnidadeService(UnidadeObraService unidadeunidadeObraService) {
		this.unidadeObraService = unidadeunidadeObraService;
	}
	
	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public void atualizar(@RequestBody UnidadeObra unidadeObra) {
		unidadeObraService.salvar(unidadeObra);
	}

	@RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		unidadeObraService.remover(id);
	}
	
	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	public UnidadeObra buscarUnidade(@PathVariable Integer id) {
		return this.unidadeObraService.buscarUnidade(id);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<UnidadeObra> findAll() {
		return unidadeObraService.listarUnidades();
	}
	
}
