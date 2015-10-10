package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the conta_pagar database table.
 * 
 */
@Entity
@Table(name="conta_pagar")
@NamedQuery(name="ContaPagar.findAll", query="SELECT c FROM ContaPagar c")
public class ContaPagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_conta_pagar")
	private int idContaPagar;

	@Temporal(TemporalType.DATE)
	@Column(name="data_pagamento")
	private Date dataPagamento;

	@Temporal(TemporalType.DATE)
	@Column(name="data_vencimento")
	private Date dataVencimento;

	@Column(name="n_parcelas")
	private int nParcelas;

	@Column(name="nota_fiscal")
	private String notaFiscal;

	private String observacao;

	private byte status;

	@Column(name="tipo_conta")
	private int tipoConta;

	@Column(name="tipo_pagamento")
	private int tipoPagamento;

	@Column(name="valor_conta")
	private BigDecimal valorConta;

	//bi-directional many-to-one association to Anexo
	@OneToMany(mappedBy="contaPagar")
	private List<Anexo> anexos;

	//bi-directional many-to-one association to Fornecedor
	@ManyToOne
	@JoinColumn(name="id_fornecedor")
	private Fornecedor fornecedor;

	//bi-directional many-to-many association to Item
	@ManyToMany(mappedBy="contaPagars")
	private List<Item> items;

	//bi-directional many-to-one association to FaseObra
	@OneToMany(mappedBy="contaPagar")
	private List<FaseObra> faseObras;

	//bi-directional many-to-one association to FormaPagamento
	@OneToMany(mappedBy="contaPagar")
	private List<FormaPagamento> formaPagamentos;

	//bi-directional many-to-one association to Lancamento
	@OneToMany(mappedBy="contaPagar")
	private List<Lancamento> lancamentos;

	public ContaPagar() {
	}

	public int getIdContaPagar() {
		return this.idContaPagar;
	}

	public void setIdContaPagar(int idContaPagar) {
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

	public int getNParcelas() {
		return this.nParcelas;
	}

	public void setNParcelas(int nParcelas) {
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

	public int getTipoConta() {
		return this.tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public int getTipoPagamento() {
		return this.tipoPagamento;
	}

	public void setTipoPagamento(int tipoPagamento) {
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
		anexo.setContaPagar(this);

		return anexo;
	}

	public Anexo removeAnexo(Anexo anexo) {
		getAnexos().remove(anexo);
		anexo.setContaPagar(null);

		return anexo;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<FaseObra> getFaseObras() {
		return this.faseObras;
	}

	public void setFaseObras(List<FaseObra> faseObras) {
		this.faseObras = faseObras;
	}

	public FaseObra addFaseObra(FaseObra faseObra) {
		getFaseObras().add(faseObra);
		faseObra.setContaPagar(this);

		return faseObra;
	}

	public FaseObra removeFaseObra(FaseObra faseObra) {
		getFaseObras().remove(faseObra);
		faseObra.setContaPagar(null);

		return faseObra;
	}

	public List<FormaPagamento> getFormaPagamentos() {
		return this.formaPagamentos;
	}

	public void setFormaPagamentos(List<FormaPagamento> formaPagamentos) {
		this.formaPagamentos = formaPagamentos;
	}

	public FormaPagamento addFormaPagamento(FormaPagamento formaPagamento) {
		getFormaPagamentos().add(formaPagamento);
		formaPagamento.setContaPagar(this);

		return formaPagamento;
	}

	public FormaPagamento removeFormaPagamento(FormaPagamento formaPagamento) {
		getFormaPagamentos().remove(formaPagamento);
		formaPagamento.setContaPagar(null);

		return formaPagamento;
	}

	public List<Lancamento> getLancamentos() {
		return this.lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Lancamento addLancamento(Lancamento lancamento) {
		getLancamentos().add(lancamento);
		lancamento.setContaPagar(this);

		return lancamento;
	}

	public Lancamento removeLancamento(Lancamento lancamento) {
		getLancamentos().remove(lancamento);
		lancamento.setContaPagar(null);

		return lancamento;
	}

}