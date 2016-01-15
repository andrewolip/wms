package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.ContaPagar;
import com.wms.model.entity.ItemConta;
import com.wms.model.entity.Obra;
import com.wms.model.entity.UnidadeObra;
import com.wms.model.service.ContaPagarService;

@RestController
@RequestMapping(value = "/contasPagar")
public class ContaPagarController {

	private ContaPagarService contaPagarService;
	
	@Autowired
	public void setContaPagarService(ContaPagarService contaPagarService) {
		this.contaPagarService = contaPagarService;
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public void atualizar(@RequestBody ContaPagar contaPagar) {
		contaPagarService.salvar(contaPagar);
	}

	@RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody ContaPagar contaPagar) {
		contaPagarService.remover(contaPagar.getIdContaPagar());
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<ContaPagar> findAll() {
		return contaPagarService.listarContasPagar();
	}
	
	@RequestMapping(value = "/listar_itens/{id}", method = RequestMethod.GET)
	public List<ItemConta> listarItensPorContaPagar(@PathVariable Integer id) {
		ContaPagar conta = new ContaPagar();
		conta = this.contaPagarService.buscarContaPagar(id);
		return conta.getItensConta(); 
	}
	
	@RequestMapping(value = "/listar_por_obra", method = RequestMethod.GET)
	public List<ContaPagar> listarContaPagarPorObra(@RequestBody Obra obra) {
		System.out.println("ID da Obra: " + obra.getIdObra());
		List<ContaPagar> lista = contaPagarService.listarPorObra(obra); 
		System.out.println("Lista de Contas a pagar" + lista);
		return lista;
	}
	
	@RequestMapping(value = "/listar_por_unidade", method = RequestMethod.GET)
	public List<ContaPagar> listarContaPagarPorUnidade(@RequestBody UnidadeObra unidadeObra) {
		return contaPagarService.listarPorUnidade(unidadeObra);
	}
}
