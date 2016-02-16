package com.wms.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.FaseUnidade;
import com.wms.model.service.FaseUnidadeService;

@RestController
@RequestMapping("/fases")
public class FaseUnidadeController {

	private FaseUnidadeService faseUnidadeService;
	
	@Autowired
	public void setFaseService(FaseUnidadeService faseService) {
		this.faseUnidadeService = faseService;
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.PUT)
	public void salvar(@RequestBody FaseUnidade faseUnidade) {
		this.faseUnidadeService.salvar(faseUnidade);
	}
	
	@RequestMapping(value = "/salvarLista", method = RequestMethod.PUT)
	public void salvarLista(@RequestBody List<FaseUnidade> fases) {
		this.faseUnidadeService.salvarLista(fases);
	}
	
	@RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
	public void remover(@RequestBody FaseUnidade fase) {
		this.faseUnidadeService.remover(fase);
	}
	
	@RequestMapping(value = "/listar", method= RequestMethod.GET)
	public Collection<FaseUnidade> listarFases() {
		return this.faseUnidadeService.listarFases();
	}
	
	@RequestMapping(value = "/listar_por_unidade/{id}", method = RequestMethod.GET)
	public Collection<FaseUnidade> listarFasesPorUnidade(@PathVariable Integer id) {
		return this.faseUnidadeService.listarFasesPorUnidade(id);
	}
	
}
