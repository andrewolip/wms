package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value = "/apagar/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody UnidadeObra unidadeObra) {
		unidadeObraService.remover(unidadeObra.getIdUnidadeObra());
	}
	
	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	public UnidadeObra buscarUnidade(@RequestBody UnidadeObra unidadeObra) {
		return this.unidadeObraService.buscarUnidade(unidadeObra.getIdUnidadeObra());
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<UnidadeObra> findAll() {
		return unidadeObraService.listarUnidades();
	}
	
}
