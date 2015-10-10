package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the categoria_item database table.
 * 
 */
@Entity
@Table(name="categoria_item")
@NamedQuery(name="CategoriaItem.findAll", query="SELECT c FROM CategoriaItem c")
public class CategoriaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_categoria_item")
	private int idCategoriaItem;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to SubcategoriaItem
	@OneToMany(mappedBy="categoriaItem")
	private List<SubcategoriaItem> subcategoriaItems;

	public CategoriaItem() {
	}

	public int getIdCategoriaItem() {
		return this.idCategoriaItem;
	}

	public void setIdCategoriaItem(int idCategoriaItem) {
		this.idCategoriaItem = idCategoriaItem;
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

	public List<SubcategoriaItem> getSubcategoriaItems() {
		return this.subcategoriaItems;
	}

	public void setSubcategoriaItems(List<SubcategoriaItem> subcategoriaItems) {
		this.subcategoriaItems = subcategoriaItems;
	}

	public SubcategoriaItem addSubcategoriaItem(SubcategoriaItem subcategoriaItem) {
		getSubcategoriaItems().add(subcategoriaItem);
		subcategoriaItem.setCategoriaItem(this);

		return subcategoriaItem;
	}

	public SubcategoriaItem removeSubcategoriaItem(SubcategoriaItem subcategoriaItem) {
		getSubcategoriaItems().remove(subcategoriaItem);
		subcategoriaItem.setCategoriaItem(null);

		return subcategoriaItem;
	}

}