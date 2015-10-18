package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the obra database table.
 * 
 */
@Entity
@NamedQuery(name="Obra.findAll", query="SELECT o FROM Obra o")
public class Obra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_obra")
	private Integer idObra;

	@Column(name="custo_previsto")
	private BigDecimal custoPrevisto;

	@Column(name="custo_realizado")
	private BigDecimal custoRealizado;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="data_prevista_termino")
	private Date dataPrevistaTermino;

	@Temporal(TemporalType.DATE)
	@Column(name="data_termino")
	private Date dataTermino;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Anexo
	@OneToMany(mappedBy="obra")
	private List<Anexo> anexos;

	//bi-directional many-to-one association to CentroCusto
	@OneToMany(mappedBy="obra")
	private List<CentroCusto> centroCustos;

	//bi-directional many-to-one association to Colaborador
	@OneToMany(mappedBy="obra")
	private List<Colaborador> colaboradors;

	//bi-directional many-to-one association to ComentarioObra
	@OneToMany(mappedBy="obra")
	private List<ComentarioObra> comentarioObras;

	//bi-directional many-to-one association to UnidadeObra
	@OneToMany(mappedBy="obra")
	private List<UnidadeObra> unidadeObras;

	public Obra() {
	}

	public Integer getIdObra() {
		return this.idObra;
	}

	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}

	public BigDecimal getCustoPrevisto() {
		return this.custoPrevisto;
	}

	public void setCustoPrevisto(BigDecimal custoPrevisto) {
		this.custoPrevisto = custoPrevisto;
	}

	public BigDecimal getCustoRealizado() {
		return this.custoRealizado;
	}

	public void setCustoRealizado(BigDecimal custoRealizado) {
		this.custoRealizado = custoRealizado;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
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

	public List<Anexo> getAnexos() {
		return this.anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}

	public Anexo addAnexo(Anexo anexo) {
		getAnexos().add(anexo);
		anexo.setObra(this);

		return anexo;
	}

	public Anexo removeAnexo(Anexo anexo) {
		getAnexos().remove(anexo);
		anexo.setObra(null);

		return anexo;
	}

	public List<CentroCusto> getCentroCustos() {
		return this.centroCustos;
	}

	public void setCentroCustos(List<CentroCusto> centroCustos) {
		this.centroCustos = centroCustos;
	}

	public CentroCusto addCentroCusto(CentroCusto centroCusto) {
		getCentroCustos().add(centroCusto);
		centroCusto.setObra(this);

		return centroCusto;
	}

	public CentroCusto removeCentroCusto(CentroCusto centroCusto) {
		getCentroCustos().remove(centroCusto);
		centroCusto.setObra(null);

		return centroCusto;
	}

	public List<Colaborador> getColaboradors() {
		return this.colaboradors;
	}

	public void setColaboradors(List<Colaborador> colaboradors) {
		this.colaboradors = colaboradors;
	}

	public Colaborador addColaborador(Colaborador colaborador) {
		getColaboradors().add(colaborador);
		colaborador.setObra(this);

		return colaborador;
	}

	public Colaborador removeColaborador(Colaborador colaborador) {
		getColaboradors().remove(colaborador);
		colaborador.setObra(null);

		return colaborador;
	}

	public List<ComentarioObra> getComentarioObras() {
		return this.comentarioObras;
	}

	public void setComentarioObras(List<ComentarioObra> comentarioObras) {
		this.comentarioObras = comentarioObras;
	}

	public ComentarioObra addComentarioObra(ComentarioObra comentarioObra) {
		getComentarioObras().add(comentarioObra);
		comentarioObra.setObra(this);

		return comentarioObra;
	}

	public ComentarioObra removeComentarioObra(ComentarioObra comentarioObra) {
		getComentarioObras().remove(comentarioObra);
		comentarioObra.setObra(null);

		return comentarioObra;
	}

	public List<UnidadeObra> getUnidadeObras() {
		return this.unidadeObras;
	}

	public void setUnidadeObras(List<UnidadeObra> unidadeObras) {
		this.unidadeObras = unidadeObras;
	}

	public UnidadeObra addUnidadeObra(UnidadeObra unidadeObra) {
		getUnidadeObras().add(unidadeObra);
		unidadeObra.setObra(this);

		return unidadeObra;
	}

	public UnidadeObra removeUnidadeObra(UnidadeObra unidadeObra) {
		getUnidadeObras().remove(unidadeObra);
		unidadeObra.setObra(null);

		return unidadeObra;
	}

}