package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the centro_custo database table.
 * 
 */
@Entity
@Table(name="centro_custo")
@NamedQuery(name="CentroCusto.findAll", query="SELECT c FROM CentroCusto c")
public class CentroCusto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_centro_custo")
	private int idCentroCusto;

	private String descricao;

	@Column(name="saldo_atual")
	private BigDecimal saldoAtual;

	//bi-directional many-to-one association to Obra
	@ManyToOne
	@JoinColumn(name="id_obra")
	private Obra obra;

	//bi-directional many-to-one association to Lancamento
	@OneToMany(mappedBy="centroCusto")
	private List<Lancamento> lancamentos;

	public CentroCusto() {
	}

	public int getIdCentroCusto() {
		return this.idCentroCusto;
	}

	public void setIdCentroCusto(int idCentroCusto) {
		this.idCentroCusto = idCentroCusto;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getSaldoAtual() {
		return this.saldoAtual;
	}

	public void setSaldoAtual(BigDecimal saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public List<Lancamento> getLancamentos() {
		return this.lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Lancamento addLancamento(Lancamento lancamento) {
		getLancamentos().add(lancamento);
		lancamento.setCentroCusto(this);

		return lancamento;
	}

	public Lancamento removeLancamento(Lancamento lancamento) {
		getLancamentos().remove(lancamento);
		lancamento.setCentroCusto(null);

		return lancamento;
	}

}