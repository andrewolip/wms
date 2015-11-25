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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categoria_item")
	private Integer idCategoriaItem;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to SubcategoriaItem
	@OneToMany(mappedBy="categoriaItem")
	private List<SubcategoriaItem> subcategoriasItem;

	public CategoriaItem() {
	}

	public Integer getIdCategoriaItem() {
		return this.idCategoriaItem;
	}

	public void setIdCategoriaItem(Integer idCategoriaItem) {
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

	public List<SubcategoriaItem> getSubcategoriasItem() {
		return this.subcategoriasItem;
	}

	public void setSubcategoriasItem(List<SubcategoriaItem> subcategoriasItem) {
		this.subcategoriasItem = subcategoriasItem;
	}

	public SubcategoriaItem addSubcategoriasItem(SubcategoriaItem subcategoriasItem) {
		getSubcategoriasItem().add(subcategoriasItem);
		subcategoriasItem.setCategoriaItem(this);

		return subcategoriasItem;
	}

	public SubcategoriaItem removeSubcategoriasItem(SubcategoriaItem subcategoriasItem) {
		getSubcategoriasItem().remove(subcategoriasItem);
		subcategoriasItem.setCategoriaItem(null);

		return subcategoriasItem;
	}

}