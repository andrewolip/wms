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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fornecedor")
	private Integer idFornecedor;

	private String contato;

	private String email;

	private String nome;

	private String observacao;

	private String telefone;

	//bi-directional many-to-one association to ContaPagar
	@OneToMany(mappedBy="fornecedor")
	private List<ContaPagar> contasPagar;

	public Fornecedor() {
	}

	public Integer getIdFornecedor() {
		return this.idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
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

	public List<ContaPagar> getContasPagar() {
		return this.contasPagar;
	}

	public void setContasPagar(List<ContaPagar> contasPagar) {
		this.contasPagar = contasPagar;
	}

	public ContaPagar addContasPagar(ContaPagar contasPagar) {
		getContasPagar().add(contasPagar);
		contasPagar.setFornecedor(this);

		return contasPagar;
	}

	public ContaPagar removeContasPagar(ContaPagar contasPagar) {
		getContasPagar().remove(contasPagar);
		contasPagar.setFornecedor(null);

		return contasPagar;
	}

}