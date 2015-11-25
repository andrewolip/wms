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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_subcategoria_item")
	private Integer idSubcategoriaItem;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="subcategoriaItem")
	private List<Item> itens;

	//bi-directional many-to-one association to CategoriaItem
	@ManyToOne
	@JoinColumn(name="id_categoria_item")
	private CategoriaItem categoriaItem;

	public SubcategoriaItem() {
	}

	public Integer getIdSubcategoriaItem() {
		return this.idSubcategoriaItem;
	}

	public void setIdSubcategoriaItem(Integer idSubcategoriaItem) {
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

	public List<Item> getItens() {
		return this.itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Item addIten(Item iten) {
		getItens().add(iten);
		iten.setSubcategoriaItem(this);

		return iten;
	}

	public Item removeIten(Item iten) {
		getItens().remove(iten);
		iten.setSubcategoriaItem(null);

		return iten;
	}

	public CategoriaItem getCategoriaItem() {
		return this.categoriaItem;
	}

	public void setCategoriaItem(CategoriaItem categoriaItem) {
		this.categoriaItem = categoriaItem;
	}

}