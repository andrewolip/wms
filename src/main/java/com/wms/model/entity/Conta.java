package com.wms.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Conta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_conta_pagar")
	private Integer idContaPagar;

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

	@Column(name="tipo_conta")
	private Integer tipoConta;

	@Column(name="tipo_pagamento")
	private Integer tipoPagamento;

	@Column(name="valor_conta")
	private BigDecimal valorConta;

	//bi-directional many-to-one association to Fornecedor
	@ManyToOne
	@JoinColumn(name="id_fornecedor")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name="id_obra")
	private Obra obra;
	
	@ManyToOne
	@JoinColumn(name="id_unidade_obra")
	private UnidadeObra unidadeObra;
	
	@ManyToOne
	@JoinColumn(name="id_fase_obra")
	private FaseUnidade faseObra;
	
	//bi-directional many-to-one association to ItemConta
	@OneToMany(mappedBy="contaPagar")
	private List<ItemConta> itensConta;

	public Conta() {
		
	}

}
