package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tarefa database table.
 * 
 */
@Entity
@NamedQuery(name="Tarefa.findAll", query="SELECT t FROM Tarefa t")
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tarefa")
	private Integer idTarefa;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to TarefaObra
	@OneToMany(mappedBy="tarefa")
	private List<TarefaObra> tarefaObras;

	public Tarefa() {
	}

	public Integer getIdTarefa() {
		return this.idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
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

	public List<TarefaObra> getTarefaObras() {
		return this.tarefaObras;
	}

	public void setTarefaObras(List<TarefaObra> tarefaObras) {
		this.tarefaObras = tarefaObras;
	}

	public TarefaObra addTarefaObra(TarefaObra tarefaObra) {
		getTarefaObras().add(tarefaObra);
		tarefaObra.setTarefa(this);

		return tarefaObra;
	}

	public TarefaObra removeTarefaObra(TarefaObra tarefaObra) {
		getTarefaObras().remove(tarefaObra);
		tarefaObra.setTarefa(null);

		return tarefaObra;
	}

}