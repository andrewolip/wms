package com.wms.controller;

import java.math.BigDecimal;
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
	
	@RequestMapping(value = "/listar_por_obra/{id}", method = RequestMethod.GET)
	public Collection<ContaPagar> listarContaPagarPorObra(@PathVariable Integer id) {
		return contaPagarService.listarPorObra(id);
	}
	
	@RequestMapping(value = "/listar_por_unidade", method = RequestMethod.GET)
	public Collection<ContaPagar> listarContaPagarPorUnidade(@RequestBody UnidadeObra unidadeObra) {
		return contaPagarService.listarPorUnidade(unidadeObra);
	}
	
	@RequestMapping(value = "/listar_contas_nao_pagas/{id}", method = RequestMethod.GET)
	public Collection<ContaPagar> listarContasNaoPagas(@PathVariable Integer id) {
		return contaPagarService.listarContasNaoPagas(id);
	}
	
	@RequestMapping(value = "/realizar_lancamento", method = RequestMethod.POST)
	public BigDecimal realizarLancamento(@RequestBody ContaPagar conta) {
		return contaPagarService.realizarLancamento(conta);
	}
	
	@RequestMapping(value = "/realizar_estorno", method = RequestMethod.POST)
	public BigDecimal realizarEstorno(@RequestBody ContaPagar conta) {
		return contaPagarService.realizarEstorno(conta);
	}
	
}
