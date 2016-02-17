package com.wms.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.ItemConta;
import com.wms.model.service.ItemContaService;

@RestController
@RequestMapping(value = "/itensConta")
public class ItemContaController {

	private ItemContaService itemContaService;

	@Autowired
	public void setItemContaService(ItemContaService itemContaService) {
		this.itemContaService = itemContaService;
	}
	
	@RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
	public void remover(@PathVariable Integer id) {
		this.itemContaService.remover(id);
	}
	
	@RequestMapping(value = "/salvarLista", method = RequestMethod.PUT)
	public void salvarLista(@RequestBody Collection<ItemConta> itensConta) {
		this.itemContaService.salvarLista(itensConta);
	}
	
	@RequestMapping(value = "/listar_por_conta/{id}", method = RequestMethod.GET)
	public Collection<ItemConta> listarItensPorContaPagar(@PathVariable Integer id) {
		return this.itemContaService.listarItensPorContaPagar(id);
	}
}
