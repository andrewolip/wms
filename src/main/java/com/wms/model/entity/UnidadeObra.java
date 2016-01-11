package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the unidade_obra database table.
 * 
 */
@Entity
@Table(name="unidade_obra")
@NamedQuery(name="UnidadeObra.findAll", query="SELECT u FROM UnidadeObra u")
public class UnidadeObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_unidade_obra")
	private Integer idUnidadeObra;

	@Temporal(TemporalType.DATE)
	@Column(name="data_entrega")
	private Date dataEntrega;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="data_prevista_termino")
	private Date dataPrevistaTermino;

	@Temporal(TemporalType.DATE)
	@Column(name="data_venda")
	private Date dataVenda;

	private String descricao;

	@Column(name="nome_unidade")
	private String nomeUnidade;

	@Column(name="valor_previsto_venda")
	private BigDecimal valorPrevistoVenda;

	@Column(name="valor_realizado_venda")
	private BigDecimal valorRealizadoVenda;

	//bi-directional many-to-one association to Anexo
	@OneToMany(mappedBy="unidadeObra")
	private List<Anexo> anexos;

	//bi-directional many-to-one association to ContaReceber
	@OneToMany(mappedBy="unidadeObra")
	private List<ContaReceber> contaRecebers;

	//bi-directional many-to-one association to FaseObra
	@OneToMany(mappedBy="unidadeObra")
	private List<FaseObra> faseObras;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Obra
	@ManyToOne
	@JoinColumn(name="id_obra")
	private Obra obra;

	public UnidadeObra() {
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}
	
	public Integer getIdUnidadeObra() {
		return this.idUnidadeObra;
	}

	public void setIdUnidadeObra(Integer idUnidadeObra) {
		this.idUnidadeObra = idUnidadeObra;
	}

	public Date getDataEntrega() {
		return this.dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
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

	public Date getDataVenda() {
		return this.dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorPrevistoVenda() {
		return this.valorPrevistoVenda;
	}

	public void setValorPrevistoVenda(BigDecimal valorPrevistoVenda) {
		this.valorPrevistoVenda = valorPrevistoVenda;
	}

	public BigDecimal getValorRealizadoVenda() {
		return this.valorRealizadoVenda;
	}

	public void setValorRealizadoVenda(BigDecimal valorRealizadoVenda) {
		this.valorRealizadoVenda = valorRealizadoVenda;
	}

	public List<Anexo> getAnexos() {
		return this.anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}

	public Anexo addAnexo(Anexo anexo) {
		getAnexos().add(anexo);
		anexo.setUnidadeObra(this);

		return anexo;
	}

	public Anexo removeAnexo(Anexo anexo) {
		getAnexos().remove(anexo);
		anexo.setUnidadeObra(null);

		return anexo;
	}

	public List<ContaReceber> getContaRecebers() {
		return this.contaRecebers;
	}

	public void setContaRecebers(List<ContaReceber> contaRecebers) {
		this.contaRecebers = contaRecebers;
	}

	public ContaReceber addContaReceber(ContaReceber contaReceber) {
		getContaRecebers().add(contaReceber);
		contaReceber.setUnidadeObra(this);

		return contaReceber;
	}

	public ContaReceber removeContaReceber(ContaReceber contaReceber) {
		getContaRecebers().remove(contaReceber);
		contaReceber.setUnidadeObra(null);

		return contaReceber;
	}

	public List<FaseObra> getFaseObras() {
		return this.faseObras;
	}

	public void setFaseObras(List<FaseObra> faseObras) {
		this.faseObras = faseObras;
	}

	public FaseObra addFaseObra(FaseObra faseObra) {
		getFaseObras().add(faseObra);
		faseObra.setUnidadeObra(this);

		return faseObra;
	}

	public FaseObra removeFaseObra(FaseObra faseObra) {
		getFaseObras().remove(faseObra);
		faseObra.setUnidadeObra(null);

		return faseObra;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

}