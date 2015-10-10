package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the forma_pagamento database table.
 * 
 */
@Entity
@Table(name="forma_pagamento")
@NamedQuery(name="FormaPagamento.findAll", query="SELECT f FROM FormaPagamento f")
public class FormaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_dados_pagamento")
	private int idDadosPagamento;

	@Temporal(TemporalType.DATE)
	@Column(name="data_desconto_cheque")
	private Date dataDescontoCheque;

	@Temporal(TemporalType.DATE)
	@Column(name="data_emissao_boleto")
	private Date dataEmissaoBoleto;

	@Temporal(TemporalType.DATE)
	@Column(name="data_vencimento_boleto")
	private Date dataVencimentoBoleto;

	private String descricao;

	@Column(name="dia_fechamento_credito")
	private int diaFechamentoCredito;

	@Column(name="dia_vencimento_creditol")
	private int diaVencimentoCreditol;

	@Column(name="forma_pagamento")
	private int formaPagamento;

	@Column(name="num_parcelas")
	private int numParcelas;

	private String observacao;

	private BigDecimal valor;

	//bi-directional many-to-one association to ContaReceber
	@OneToMany(mappedBy="formaPagamento")
	private List<ContaReceber> contaRecebers;

	//bi-directional many-to-one association to ContaBancaria
	@ManyToOne
	@JoinColumn(name="id_conta_bancaria")
	private ContaBancaria contaBancaria;

	//bi-directional many-to-one association to ContaPagar
	@ManyToOne
	@JoinColumn(name="id_conta_pagar")
	private ContaPagar contaPagar;

	//bi-directional many-to-one association to OpcaoPagamento
	@ManyToOne
	@JoinColumn(name="id_opcao_pagamento")
	private OpcaoPagamento opcaoPagamento;

	//bi-directional many-to-one association to Parcela
	@OneToMany(mappedBy="formaPagamento")
	private List<Parcela> parcelas;

	public FormaPagamento() {
	}

	public int getIdDadosPagamento() {
		return this.idDadosPagamento;
	}

	public void setIdDadosPagamento(int idDadosPagamento) {
		this.idDadosPagamento = idDadosPagamento;
	}

	public Date getDataDescontoCheque() {
		return this.dataDescontoCheque;
	}

	public void setDataDescontoCheque(Date dataDescontoCheque) {
		this.dataDescontoCheque = dataDescontoCheque;
	}

	public Date getDataEmissaoBoleto() {
		return this.dataEmissaoBoleto;
	}

	public void setDataEmissaoBoleto(Date dataEmissaoBoleto) {
		this.dataEmissaoBoleto = dataEmissaoBoleto;
	}

	public Date getDataVencimentoBoleto() {
		return this.dataVencimentoBoleto;
	}

	public void setDataVencimentoBoleto(Date dataVencimentoBoleto) {
		this.dataVencimentoBoleto = dataVencimentoBoleto;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDiaFechamentoCredito() {
		return this.diaFechamentoCredito;
	}

	public void setDiaFechamentoCredito(int diaFechamentoCredito) {
		this.diaFechamentoCredito = diaFechamentoCredito;
	}

	public int getDiaVencimentoCreditol() {
		return this.diaVencimentoCreditol;
	}

	public void setDiaVencimentoCreditol(int diaVencimentoCreditol) {
		this.diaVencimentoCreditol = diaVencimentoCreditol;
	}

	public int getFormaPagamento() {
		return this.formaPagamento;
	}

	public void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public int getNumParcelas() {
		return this.numParcelas;
	}

	public void setNumParcelas(int numParcelas) {
		this.numParcelas = numParcelas;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<ContaReceber> getContaRecebers() {
		return this.contaRecebers;
	}

	public void setContaRecebers(List<ContaReceber> contaRecebers) {
		this.contaRecebers = contaRecebers;
	}

	public ContaReceber addContaReceber(ContaReceber contaReceber) {
		getContaRecebers().add(contaReceber);
		contaReceber.setFormaPagamento(this);

		return contaReceber;
	}

	public ContaReceber removeContaReceber(ContaReceber contaReceber) {
		getContaRecebers().remove(contaReceber);
		contaReceber.setFormaPagamento(null);

		return contaReceber;
	}

	public ContaBancaria getContaBancaria() {
		return this.contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public ContaPagar getContaPagar() {
		return this.contaPagar;
	}

	public void setContaPagar(ContaPagar contaPagar) {
		this.contaPagar = contaPagar;
	}

	public OpcaoPagamento getOpcaoPagamento() {
		return this.opcaoPagamento;
	}

	public void setOpcaoPagamento(OpcaoPagamento opcaoPagamento) {
		this.opcaoPagamento = opcaoPagamento;
	}

	public List<Parcela> getParcelas() {
		return this.parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public Parcela addParcela(Parcela parcela) {
		getParcelas().add(parcela);
		parcela.setFormaPagamento(this);

		return parcela;
	}

	public Parcela removeParcela(Parcela parcela) {
		getParcelas().remove(parcela);
		parcela.setFormaPagamento(null);

		return parcela;
	}

}