package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the item_conta database table.
 * 
 */
@Entity
@Table(name="item_conta")
@NamedQuery(name="ItemConta.findAll", query="SELECT i FROM ItemConta i")
public class ItemConta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item")
	private Integer idItem;

	private String descricao;

	private String nome;

	private Integer quantidade;

	private String unidade;

	@Column(name="valor_unitario")
	private BigDecimal valorUnitario;

	//bi-directional many-to-one association to ContaPagar
	@ManyToOne
	@JoinColumn(name="id_conta_pagar")
	private ContaPagar contaPagar;

	public ItemConta() {
	}

	public Integer getIdItem() {
		return this.idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
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

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public ContaPagar getContaPagar() {
		return this.contaPagar;
	}

	public void setContaPagar(ContaPagar contaPagar) {
		this.contaPagar = contaPagar;
	}

}