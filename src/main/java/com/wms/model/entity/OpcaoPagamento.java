package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the opcao_pagamento database table.
 * 
 */
@Entity
@Table(name="opcao_pagamento")
@NamedQuery(name="OpcaoPagamento.findAll", query="SELECT o FROM OpcaoPagamento o")
public class OpcaoPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_opcao_pagamento")
	private int idOpcaoPagamento;

	@Column(name="a_vista")
	private byte aVista;

	private String descricao;

	private String nome;

	private byte parcelado;

	//bi-directional many-to-one association to FormaPagamento
	@OneToMany(mappedBy="opcaoPagamento")
	private List<FormaPagamento> formaPagamentos;

	public OpcaoPagamento() {
	}

	public int getIdOpcaoPagamento() {
		return this.idOpcaoPagamento;
	}

	public void setIdOpcaoPagamento(int idOpcaoPagamento) {
		this.idOpcaoPagamento = idOpcaoPagamento;
	}

	public byte getAVista() {
		return this.aVista;
	}

	public void setAVista(byte aVista) {
		this.aVista = aVista;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte getParcelado() {
		return this.parcelado;
	}

	public void setParcelado(byte parcelado) {
		this.parcelado = parcelado;
	}

	public List<FormaPagamento> getFormaPagamentos() {
		return this.formaPagamentos;
	}

	public void setFormaPagamentos(List<FormaPagamento> formaPagamentos) {
		this.formaPagamentos = formaPagamentos;
	}

	public FormaPagamento addFormaPagamento(FormaPagamento formaPagamento) {
		getFormaPagamentos().add(formaPagamento);
		formaPagamento.setOpcaoPagamento(this);

		return formaPagamento;
	}

	public FormaPagamento removeFormaPagamento(FormaPagamento formaPagamento) {
		getFormaPagamentos().remove(formaPagamento);
		formaPagamento.setOpcaoPagamento(null);

		return formaPagamento;
	}

}