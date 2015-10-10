package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the lancamento database table.
 * 
 */
@Entity
@NamedQuery(name="Lancamento.findAll", query="SELECT l FROM Lancamento l")
public class Lancamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_lancamento")
	private int idLancamento;

	@Temporal(TemporalType.DATE)
	@Column(name="data_lancamento")
	private Date dataLancamento;

	private String observacao;

	@Column(name="valor_lancamento")
	private BigDecimal valorLancamento;

	//bi-directional many-to-one association to Anexo
	@OneToMany(mappedBy="lancamento")
	private List<Anexo> anexos;

	//bi-directional many-to-one association to CentroCusto
	@ManyToOne
	@JoinColumn(name="id_centro_custo")
	private CentroCusto centroCusto;

	//bi-directional many-to-one association to ContaPagar
	@ManyToOne
	@JoinColumn(name="id_conta_pagar")
	private ContaPagar contaPagar;

	//bi-directional many-to-one association to ContaReceber
	@ManyToOne
	@JoinColumn(name="id_conta_receber")
	private ContaReceber contaReceber;

	public Lancamento() {
	}

	public int getIdLancamento() {
		return this.idLancamento;
	}

	public void setIdLancamento(int idLancamento) {
		this.idLancamento = idLancamento;
	}

	public Date getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValorLancamento() {
		return this.valorLancamento;
	}

	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public List<Anexo> getAnexos() {
		return this.anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}

	public Anexo addAnexo(Anexo anexo) {
		getAnexos().add(anexo);
		anexo.setLancamento(this);

		return anexo;
	}

	public Anexo removeAnexo(Anexo anexo) {
		getAnexos().remove(anexo);
		anexo.setLancamento(null);

		return anexo;
	}

	public CentroCusto getCentroCusto() {
		return this.centroCusto;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public ContaPagar getContaPagar() {
		return this.contaPagar;
	}

	public void setContaPagar(ContaPagar contaPagar) {
		this.contaPagar = contaPagar;
	}

	public ContaReceber getContaReceber() {
		return this.contaReceber;
	}

	public void setContaReceber(ContaReceber contaReceber) {
		this.contaReceber = contaReceber;
	}

}