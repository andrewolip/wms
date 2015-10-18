package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item")
	private Integer idItem;

	private String descricao;

	private String nome;

	//bi-directional many-to-many association to ContaPagar
	@ManyToMany
	@JoinTable(
		name="conta_pagar_has_item"
		, joinColumns={
			@JoinColumn(name="id_item")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_conta_pagar")
			}
		)
	private List<ContaPagar> contaPagars;

	//bi-directional many-to-one association to SubcategoriaItem
	@ManyToOne
	@JoinColumn(name="id_subcategoria_item")
	private SubcategoriaItem subcategoriaItem;

	public Item() {
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

	public List<ContaPagar> getContaPagars() {
		return this.contaPagars;
	}

	public void setContaPagars(List<ContaPagar> contaPagars) {
		this.contaPagars = contaPagars;
	}

	public SubcategoriaItem getSubcategoriaItem() {
		return this.subcategoriaItem;
	}

	public void setSubcategoriaItem(SubcategoriaItem subcategoriaItem) {
		this.subcategoriaItem = subcategoriaItem;
	}

}