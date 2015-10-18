package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the funcao database table.
 * 
 */
@Entity
@NamedQuery(name="Funcao.findAll", query="SELECT f FROM Funcao f")
public class Funcao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_funcao")
	private Integer idFuncao;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Colaborador
	@OneToMany(mappedBy="funcao")
	private List<Colaborador> colaboradors;

	public Funcao() {
	}

	public Integer getIdFuncao() {
		return this.idFuncao;
	}

	public void setIdFuncao(Integer idFuncao) {
		this.idFuncao = idFuncao;
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

	public List<Colaborador> getColaboradors() {
		return this.colaboradors;
	}

	public void setColaboradors(List<Colaborador> colaboradors) {
		this.colaboradors = colaboradors;
	}

	public Colaborador addColaborador(Colaborador colaborador) {
		getColaboradors().add(colaborador);
		colaborador.setFuncao(this);

		return colaborador;
	}

	public Colaborador removeColaborador(Colaborador colaborador) {
		getColaboradors().remove(colaborador);
		colaborador.setFuncao(null);

		return colaborador;
	}

}