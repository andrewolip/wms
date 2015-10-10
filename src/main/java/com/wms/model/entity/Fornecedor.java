package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the fornecedor database table.
 * 
 */
@Entity
@NamedQuery(name="Fornecedor.findAll", query="SELECT f FROM Fornecedor f")
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_fornecedor")
	private int idFornecedor;

	private String contato;

	private String email;

	private String nome;

	private String observacao;

	private String telefone;

	//bi-directional many-to-one association to ContaPagar
	@OneToMany(mappedBy="fornecedor")
	private List<ContaPagar> contaPagars;

	//bi-directional many-to-one association to SubcategoriaItem
	@OneToMany(mappedBy="fornecedor")
	private List<SubcategoriaItem> subcategoriaItems;

	public Fornecedor() {
	}

	public int getIdFornecedor() {
		return this.idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<ContaPagar> getContaPagars() {
		return this.contaPagars;
	}

	public void setContaPagars(List<ContaPagar> contaPagars) {
		this.contaPagars = contaPagars;
	}

	public ContaPagar addContaPagar(ContaPagar contaPagar) {
		getContaPagars().add(contaPagar);
		contaPagar.setFornecedor(this);

		return contaPagar;
	}

	public ContaPagar removeContaPagar(ContaPagar contaPagar) {
		getContaPagars().remove(contaPagar);
		contaPagar.setFornecedor(null);

		return contaPagar;
	}

	public List<SubcategoriaItem> getSubcategoriaItems() {
		return this.subcategoriaItems;
	}

	public void setSubcategoriaItems(List<SubcategoriaItem> subcategoriaItems) {
		this.subcategoriaItems = subcategoriaItems;
	}

	public SubcategoriaItem addSubcategoriaItem(SubcategoriaItem subcategoriaItem) {
		getSubcategoriaItems().add(subcategoriaItem);
		subcategoriaItem.setFornecedor(this);

		return subcategoriaItem;
	}

	public SubcategoriaItem removeSubcategoriaItem(SubcategoriaItem subcategoriaItem) {
		getSubcategoriaItems().remove(subcategoriaItem);
		subcategoriaItem.setFornecedor(null);

		return subcategoriaItem;
	}

}