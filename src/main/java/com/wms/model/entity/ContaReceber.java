package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the conta_receber database table.
 * 
 */
@Entity
@Table(name="conta_receber")
@NamedQuery(name="ContaReceber.findAll", query="SELECT c FROM ContaReceber c")
public class ContaReceber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_conta")
	private Integer idConta;

	@Temporal(TemporalType.DATE)
	@Column(name="data_pagamento")
	private Date dataPagamento;

	@Temporal(TemporalType.DATE)
	@Column(name="data_vencimento")
	private Date dataVencimento;

	@Column(name="n_parcelas")
	private Integer nParcelas;

	@Column(name="nota_fiscal")
	private String notaFiscal;

	private String observacao;

	private byte status;

	@Column(name="tipo_conta")
	private Integer tipoConta;

	@Column(name="tipo_pagamento")
	private Integer tipoPagamento;

	@Column(name="valor_conta")
	private BigDecimal valorConta;

	//bi-directional many-to-one association to Anexo
	@OneToMany(mappedBy="contaReceber")
	private List<Anexo> anexos;

	//bi-directional many-to-one association to FormaPagamento
	@ManyToOne
	@JoinColumn(name="id_dados_pagamento")
	private FormaPagamento formaPagamento;

	//bi-directional many-to-one association to UnidadeObra
	@ManyToOne
	@JoinColumn(name="id_unidade_obra")
	private UnidadeObra unidadeObra;

	//bi-directional many-to-one association to Lancamento
	@OneToMany(mappedBy="contaReceber")
	private List<Lancamento> lancamentos;

	public ContaReceber() {
	}

	public Integer getIdConta() {
		return this.idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public Date getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getNParcelas() {
		return this.nParcelas;
	}

	public void setNParcelas(Integer nParcelas) {
		this.nParcelas = nParcelas;
	}

	public String getNotaFiscal() {
		return this.notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Integer getTipoConta() {
		return this.tipoConta;
	}

	public void setTipoConta(Integer tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Integer getTipoPagamento() {
		return this.tipoPagamento;
	}

	public void setTipoPagamento(Integer tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public BigDecimal getValorConta() {
		return this.valorConta;
	}

	public void setValorConta(BigDecimal valorConta) {
		this.valorConta = valorConta;
	}

	public List<Anexo> getAnexos() {
		return this.anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}

	public Anexo addAnexo(Anexo anexo) {
		getAnexos().add(anexo);
		anexo.setContaReceber(this);

		return anexo;
	}

	public Anexo removeAnexo(Anexo anexo) {
		getAnexos().remove(anexo);
		anexo.setContaReceber(null);

		return anexo;
	}

	public FormaPagamento getFormaPagamento() {
		return this.formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public UnidadeObra getUnidadeObra() {
		return this.unidadeObra;
	}

	public void setUnidadeObra(UnidadeObra unidadeObra) {
		this.unidadeObra = unidadeObra;
	}

	public List<Lancamento> getLancamentos() {
		return this.lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Lancamento addLancamento(Lancamento lancamento) {
		getLancamentos().add(lancamento);
		lancamento.setContaReceber(this);

		return lancamento;
	}

	public Lancamento removeLancamento(Lancamento lancamento) {
		getLancamentos().remove(lancamento);
		lancamento.setContaReceber(null);

		return lancamento;
	}

}