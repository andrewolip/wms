package com.wms.model.service;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.ContaPagar;
import com.wms.model.entity.Obra;
import com.wms.model.entity.UnidadeObra;
import com.wms.model.repository.ContaPagarRepository;

@Service
public class ContaPagarService {

	private ContaPagarRepository contaPagarRepository;
	private ObraService obraService;
	
	@Autowired
	public void setObraService(ObraService obraService) {
		this.obraService = obraService;
	}

	@Autowired
	public void setContaPagarRepository(
			ContaPagarRepository contaPagarRepository) {
		this.contaPagarRepository = contaPagarRepository;
	}

	public ContaPagar salvar(ContaPagar contaPagar) {
		this.contaPagarRepository.save(contaPagar);
		return contaPagar;
	}

	public void remover(Integer id) {
		contaPagarRepository.delete(id);
	}

	public Collection<ContaPagar> listarContasPagar() {
		return (Collection<ContaPagar>) contaPagarRepository.findAll();
	}

	public ContaPagar getContaPagar(Integer id) {
		return contaPagarRepository.findOne(id);
	}

	public ContaPagar buscarContaPagar(Integer id) {
		return contaPagarRepository.findOne(id);
	}

	public ContaPagar buscarContaPagarPorNotaFiscal(Long notaFiscal) {
		ContaPagar c = contaPagarRepository.findByNotaFiscal(notaFiscal);
		return c;
	}

	public Collection<ContaPagar> listarPorObra(Obra obra) {
		return this.contaPagarRepository.findByObra(obra);
	}

	public Collection<ContaPagar> listarPorObra(Integer id) {
		return this.contaPagarRepository.findByObraIdObra(id);
	}

	public Collection<ContaPagar> listarPorUnidade(UnidadeObra unidadeObra) {
		return this.contaPagarRepository.findByUnidadeObra(unidadeObra);
	}

	public Collection<ContaPagar> listarContasNaoPagas(Integer id) {
		return contaPagarRepository.listarContasNaoPagas(id);
	}

	public BigDecimal realizarLancamento(ContaPagar conta) {
		Obra obra = obraService.buscarObra(conta.getObra().getIdObra());

		if(obra.getCustoRealizado() == null) {
			obra.setCustoRealizado(new BigDecimal(0));
		}
		
		BigDecimal soma = obra.getCustoRealizado().add(conta.getValorConta());

		obra.setCustoRealizado(soma);
		
		conta.setStatus(2);
		
		obraService.salvar(obra);
		this.salvar(conta);
		return soma;

	}

	public BigDecimal realizarEstorno(ContaPagar conta) {
		
		Obra obra = obraService.buscarObra(conta.getObra().getIdObra());
		BigDecimal resultado = obra.getCustoRealizado().subtract(conta.getValorConta());

		obra.setCustoRealizado(resultado);
		
		conta.setStatus(1);

		obraService.salvar(obra);
		this.salvar(conta);
		return resultado;
	}

}
