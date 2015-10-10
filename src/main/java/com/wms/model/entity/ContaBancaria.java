package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conta_bancaria database table.
 * 
 */
@Entity
@Table(name="conta_bancaria")
@NamedQuery(name="ContaBancaria.findAll", query="SELECT c FROM ContaBancaria c")
public class ContaBancaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_conta_bancaria")
	private int idContaBancaria;

	private String agencia;

	private int banco;

	@Column(name="conta_bancaria")
	private String contaBancaria;

	private String titular;

	//bi-directional many-to-one association to FormaPagamento
	@OneToMany(mappedBy="contaBancaria")
	private List<FormaPagamento> formaPagamentos;

	public ContaBancaria() {
	}

	public int getIdContaBancaria() {
		return this.idContaBancaria;
	}

	public void setIdContaBancaria(int idContaBancaria) {
		this.idContaBancaria = idContaBancaria;
	}

	public String getAgencia() {
		return this.agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public int getBanco() {
		return this.banco;
	}

	public void setBanco(int banco) {
		this.banco = banco;
	}

	public String getContaBancaria() {
		return this.contaBancaria;
	}

	public void setContaBancaria(String contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public List<FormaPagamento> getFormaPagamentos() {
		return this.formaPagamentos;
	}

	public void setFormaPagamentos(List<FormaPagamento> formaPagamentos) {
		this.formaPagamentos = formaPagamentos;
	}

	public FormaPagamento addFormaPagamento(FormaPagamento formaPagamento) {
		getFormaPagamentos().add(formaPagamento);
		formaPagamento.setContaBancaria(this);

		return formaPagamento;
	}

	public FormaPagamento removeFormaPagamento(FormaPagamento formaPagamento) {
		getFormaPagamentos().remove(formaPagamento);
		formaPagamento.setContaBancaria(null);

		return formaPagamento;
	}

}