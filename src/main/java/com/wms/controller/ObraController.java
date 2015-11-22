package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.Obra;
import com.wms.model.service.ObraService;

@RestController
@RequestMapping(value = "/obras")
public class ObraController {

	private ObraService obraService;
	
	@Autowired
	public void setObraService(ObraService obraService) {
		this.obraService = obraService;
	}

	/*	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public void inserir(@RequestBody Obra obra) {
		obraService.salvar(obra);
	} */
	
	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	public Obra buscar(@PathVariable Integer id) {
		return this.obraService.buscarObra(id);
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Obra obra) {
		obraService.salvar(obra);
	}

	@RequestMapping(value = "/apagar/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		obraService.remover(id);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<Obra> findAll() {
		return obraService.listarObras();
	}

}
