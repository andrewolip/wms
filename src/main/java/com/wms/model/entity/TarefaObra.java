package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the tarefa_obra database table.
 * 
 */
@Entity
@Table(name="tarefa_obra")
@NamedQuery(name="TarefaObra.findAll", query="SELECT t FROM TarefaObra t")
public class TarefaObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tarefa_obra")
	private int idTarefaObra;

	private String observacao;

	private BigDecimal progresso;

	private int status;

	//bi-directional many-to-one association to FaseObra
	@ManyToOne
	@JoinColumn(name="id_fase")
	private FaseObra faseObra;

	//bi-directional many-to-one association to Tarefa
	@ManyToOne
	@JoinColumn(name="id_tarefa")
	private Tarefa tarefa;

	public TarefaObra() {
	}

	public int getIdTarefaObra() {
		return this.idTarefaObra;
	}

	public void setIdTarefaObra(int idTarefaObra) {
		this.idTarefaObra = idTarefaObra;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getProgresso() {
		return this.progresso;
	}

	public void setProgresso(BigDecimal progresso) {
		this.progresso = progresso;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public FaseObra getFaseObra() {
		return this.faseObra;
	}

	public void setFaseObra(FaseObra faseObra) {
		this.faseObra = faseObra;
	}

	public Tarefa getTarefa() {
		return this.tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

}