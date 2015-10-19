package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the parcela database table.
 * 
 */
@Entity
@NamedQuery(name="Parcela.findAll", query="SELECT p FROM Parcela p")
public class Parcela implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_parcela")
	private Integer idParcela;

	@Temporal(TemporalType.DATE)
	@Column(name="data_vencimento")
	private Date dataVencimento;

	@Column(name="id_boleto")
	private Integer idBoleto;

	@Column(name="id_cartao_credito")
	private Integer idCartaoCredito;

	@Column(name="id_cheque")
	private Integer idCheque;

	@Column(name="n_parcela")
	private BigDecimal nParcela;

	private byte status;

	@Column(name="valor_parcela")
	private BigDecimal valorParcela;

	//bi-directional many-to-one association to FormaPagamento
	@ManyToOne
	@JoinColumn(name="id_dados_pagamento")
	private FormaPagamento formaPagamento;

	public Parcela() {
	}

	public Integer getIdParcela() {
		return this.idParcela;
	}

	public void setIdParcela(Integer idParcela) {
		this.idParcela = idParcela;
	}

	public Date getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getIdBoleto() {
		return this.idBoleto;
	}

	public void setIdBoleto(Integer idBoleto) {
		this.idBoleto = idBoleto;
	}

	public Integer getIdCartaoCredito() {
		return this.idCartaoCredito;
	}

	public void setIdCartaoCredito(Integer idCartaoCredito) {
		this.idCartaoCredito = idCartaoCredito;
	}

	public Integer getIdCheque() {
		return this.idCheque;
	}

	public void setIdCheque(Integer idCheque) {
		this.idCheque = idCheque;
	}

	public BigDecimal getNParcela() {
		return this.nParcela;
	}

	public void setNParcela(BigDecimal nParcela) {
		this.nParcela = nParcela;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public BigDecimal getValorParcela() {
		return this.valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	public FormaPagamento getFormaPagamento() {
		return this.formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}