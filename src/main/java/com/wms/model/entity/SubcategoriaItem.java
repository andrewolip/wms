package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the subcategoria_item database table.
 * 
 */
@Entity
@Table(name="subcategoria_item")
@NamedQuery(name="SubcategoriaItem.findAll", query="SELECT s FROM SubcategoriaItem s")
public class SubcategoriaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_subcategoria_item")
	private int idSubcategoriaItem;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="subcategoriaItem")
	private List<Item> items;

	//bi-directional many-to-one association to CategoriaItem
	@ManyToOne
	@JoinColumn(name="id_categoria_item")
	private CategoriaItem categoriaItem;

	//bi-directional many-to-one association to Fornecedor
	@ManyToOne
	@JoinColumn(name="id_fornecedor")
	private Fornecedor fornecedor;

	public SubcategoriaItem() {
	}

	public int getIdSubcategoriaItem() {
		return this.idSubcategoriaItem;
	}

	public void setIdSubcategoriaItem(int idSubcategoriaItem) {
		this.idSubcategoriaItem = idSubcategoriaItem;
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

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setSubcategoriaItem(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setSubcategoriaItem(null);

		return item;
	}

	public CategoriaItem getCategoriaItem() {
		return this.categoriaItem;
	}

	public void setCategoriaItem(CategoriaItem categoriaItem) {
		this.categoriaItem = categoriaItem;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}