package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cliente")
	private int idCliente;

	private String bairro;

	private String cep;

	private String complemento;

	@Column(name="cpf_cnpj")
	private String cpfCnpj;

	private String logradouro;

	@Column(name="nome_fantasia")
	private String nomeFantasia;

	@Column(name="nome_razao_social")
	private String nomeRazaoSocial;

	private String numero;

	private String observacao;

	private String rg;

	private String telefone;

	//bi-directional many-to-one association to UnidadeObra
	@OneToMany(mappedBy="cliente")
	private List<UnidadeObra> unidadeObras;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpfCnpj() {
		return this.cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeRazaoSocial() {
		return this.nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<UnidadeObra> getUnidadeObras() {
		return this.unidadeObras;
	}

	public void setUnidadeObras(List<UnidadeObra> unidadeObras) {
		this.unidadeObras = unidadeObras;
	}

	public UnidadeObra addUnidadeObra(UnidadeObra unidadeObra) {
		getUnidadeObras().add(unidadeObra);
		unidadeObra.setCliente(this);

		return unidadeObra;
	}

	public UnidadeObra removeUnidadeObra(UnidadeObra unidadeObra) {
		getUnidadeObras().remove(unidadeObra);
		unidadeObra.setCliente(null);

		return unidadeObra;
	}

}