package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")
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

//	//bi-directional many-to-one association to UnidadeObra
//	@OneToMany(mappedBy="coordenador")
//	private List<Obra> obras;

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

//	public List<Obra> getObras() {
//		return this.obras;
//	}
//
//	public void setObras(List<Obra> obras) {
//		this.obras = obras;
//	}

//	public Obra addObra(Obra obra) {
//		getObras().add(obra);
//		obra.setUsuario(this);
//
//		return obra;
//	}
//
//	public Obra removeObra(Obra obra) {
//		getObras().remove(obra);
//		obra.setUsuario(null);
//
//		return obra;
//	}

}