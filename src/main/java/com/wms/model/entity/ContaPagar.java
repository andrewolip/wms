package com.wms.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the conta_pagar database table.
 * 
 */
@Entity
@Table(name = "conta_pagar")
@NamedQuery(name = "ContaPagar.findAll", query = "SELECT c FROM ContaPagar c")
public class ContaPagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta_pagar")
	private Integer idContaPagar;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_pagamento")
	private Date dataPagamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_vencimento")
	private Date dataVencimento;

	@Column(name = "n_parcelas")
	private Integer nParcelas;

	@Column(name = "nota_fiscal")
	private Long notaFiscal;

	private String observacao;

	private Integer status;

	@Column(name = "tipo_conta")
	private Integer tipoConta;

	@Column(name = "tipo_pagamento")
	private Integer tipoPagamento;

	@Column(name = "valor_conta")
	private BigDecimal valorConta;

	// bi-directional many-to-one association to Fornecedor
	@ManyToOne
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;

	@ManyToOne
	@JoinColumn(name = "id_obra")
	private Obra obra;

	@ManyToOne
	@JoinColumn(name = "id_unidade_obra")
	private UnidadeObra unidadeObra;

	@ManyToOne
	@JoinColumn(name = "id_fase_obra")
	private FaseUnidade faseObra;

	// bi-directional many-to-one association to ItemConta
	@OneToMany(mappedBy = "contaPagar", cascade = CascadeType.ALL)
	private List<ItemConta> itensConta;

	public ContaPagar() {
	}

	public Integer getIdContaPagar() {
		return this.idContaPagar;
	}

	public void setIdContaPagar(Integer idContaPagar) {
		this.idContaPagar = idContaPagar;
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

	public Long getNotaFiscal() {
		return this.notaFiscal;
	}

	public void setNotaFiscal(Long notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
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

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Integer getnParcelas() {
		return nParcelas;
	}

	public void setnParcelas(Integer nParcelas) {
		this.nParcelas = nParcelas;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public UnidadeObra getUnidadeObra() {
		return unidadeObra;
	}

	public void setUnidadeObra(UnidadeObra unidadeObra) {
		this.unidadeObra = unidadeObra;
	}

	public FaseUnidade getFaseObra() {
		return faseObra;
	}

	public void setFaseObra(FaseUnidade faseObra) {
		this.faseObra = faseObra;
	}

}