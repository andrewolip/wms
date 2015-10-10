package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fase_obra database table.
 * 
 */
@Entity
@Table(name="fase_obra")
@NamedQuery(name="FaseObra.findAll", query="SELECT f FROM FaseObra f")
public class FaseObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_fase_obra")
	private int idFaseObra;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="data_prevista_inicio")
	private Date dataPrevistaInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="data_prevista_termino")
	private Date dataPrevistaTermino;

	@Temporal(TemporalType.DATE)
	@Column(name="data_termino")
	private Date dataTermino;

	private String observacao;

	private int status;

	@Column(name="valor_previsto")
	private BigDecimal valorPrevisto;

	@Column(name="valor_realizado")
	private BigDecimal valorRealizado;

	//bi-directional many-to-one association to ContaPagar
	@ManyToOne
	@JoinColumn(name="id_conta")
	private ContaPagar contaPagar;

	//bi-directional many-to-one association to Fase
	@ManyToOne
	@JoinColumn(name="id_fase")
	private Fase fase;

	//bi-directional many-to-one association to UnidadeObra
	@ManyToOne
	@JoinColumn(name="id_unidade_obra")
	private UnidadeObra unidadeObra;

	//bi-directional many-to-one association to TarefaObra
	@OneToMany(mappedBy="faseObra")
	private List<TarefaObra> tarefaObras;

	public FaseObra() {
	}

	public int getIdFaseObra() {
		return this.idFaseObra;
	}

	public void setIdFaseObra(int idFaseObra) {
		this.idFaseObra = idFaseObra;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataPrevistaInicio() {
		return this.dataPrevistaInicio;
	}

	public void setDataPrevistaInicio(Date dataPrevistaInicio) {
		this.dataPrevistaInicio = dataPrevistaInicio;
	}

	public Date getDataPrevistaTermino() {
		return this.dataPrevistaTermino;
	}

	public void setDataPrevistaTermino(Date dataPrevistaTermino) {
		this.dataPrevistaTermino = dataPrevistaTermino;
	}

	public Date getDataTermino() {
		return this.dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigDecimal getValorPrevisto() {
		return this.valorPrevisto;
	}

	public void setValorPrevisto(BigDecimal valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}

	public BigDecimal getValorRealizado() {
		return this.valorRealizado;
	}

	public void setValorRealizado(BigDecimal valorRealizado) {
		this.valorRealizado = valorRealizado;
	}

	public ContaPagar getContaPagar() {
		return this.contaPagar;
	}

	public void setContaPagar(ContaPagar contaPagar) {
		this.contaPagar = contaPagar;
	}

	public Fase getFase() {
		return this.fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public UnidadeObra getUnidadeObra() {
		return this.unidadeObra;
	}

	public void setUnidadeObra(UnidadeObra unidadeObra) {
		this.unidadeObra = unidadeObra;
	}

	public List<TarefaObra> getTarefaObras() {
		return this.tarefaObras;
	}

	public void setTarefaObras(List<TarefaObra> tarefaObras) {
		this.tarefaObras = tarefaObras;
	}

	public TarefaObra addTarefaObra(TarefaObra tarefaObra) {
		getTarefaObras().add(tarefaObra);
		tarefaObra.setFaseObra(this);

		return tarefaObra;
	}

	public TarefaObra removeTarefaObra(TarefaObra tarefaObra) {
		getTarefaObras().remove(tarefaObra);
		tarefaObra.setFaseObra(null);

		return tarefaObra;
	}

}