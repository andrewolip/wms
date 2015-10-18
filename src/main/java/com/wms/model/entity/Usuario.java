package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	private String login;

	private String nome;

	private int perfil;

	private String senha;

	//bi-directional many-to-one association to UnidadeObra
	@OneToMany(mappedBy="usuario")
	private List<UnidadeObra> unidadeObras;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPerfil() {
		return this.perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<UnidadeObra> getUnidadeObras() {
		return this.unidadeObras;
	}

	public void setUnidadeObras(List<UnidadeObra> unidadeObras) {
		this.unidadeObras = unidadeObras;
	}

	public UnidadeObra addUnidadeObra(UnidadeObra unidadeObra) {
		getUnidadeObras().add(unidadeObra);
		unidadeObra.setUsuario(this);

		return unidadeObra;
	}

	public UnidadeObra removeUnidadeObra(UnidadeObra unidadeObra) {
		getUnidadeObras().remove(unidadeObra);
		unidadeObra.setUsuario(null);

		return unidadeObra;
	}

}