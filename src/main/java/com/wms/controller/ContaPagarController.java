package com.wms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.ContaPagar;
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
	
	@RequestMapping(value = "/buscarPorNotaFiscal/{notaFiscal}", method = RequestMethod.GET)
	public ContaPagar buscar(@PathVariable Long notaFiscal) {
		return this.contaPagarService.buscarContaPagarPorNotaFiscal(notaFiscal);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.PUT)
	public ContaPagar inserirContaPagar(@RequestBody ContaPagar contaPagar) {
		return contaPagarService.salvar(contaPagar);
	}	
	
	@RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody ContaPagar contaPagar) {
		contaPagarService.remover(contaPagar.getIdContaPagar());
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public Collection<ContaPagar> findAll() {
		return contaPagarService.listarContasPagar();
	}
	
//	@RequestMapping(value = "/listar_por_obra", method = RequestMethod.GET)
//	public Collection<ContaPagar> listarContaPagarPorObra(@RequestBody Obra obra) {
//		System.out.println("ID da Obra: " + obra.getIdObra());
//		Collection<ContaPagar> lista = contaPagarService.listarPorObra(obra); 
//		System.out.println("Lista de Contas a pagar" + lista);
//		return lista;
//	}
	
	@RequestMapping(value = "/listar_por_unidade", method = RequestMethod.GET)
	public Collection<ContaPagar> listarContaPagarPorUnidade(@RequestBody UnidadeObra unidadeObra) {
		return contaPagarService.listarPorUnidade(unidadeObra);
	}
}
