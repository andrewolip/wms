package com.wms.model.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the anexo database table.
 * 
 */
@Entity
@NamedQuery(name="Anexo.findAll", query="SELECT a FROM Anexo a")
public class Anexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_anexo")
	private Integer idAnexo;

	@Lob
	private byte[] arquivo;

	@Lob
	private String descricao;

	private String nome;

	//bi-directional many-to-one association to ContaPagar
	@ManyToOne
	@JoinColumn(name="id_conta_pagar")
	private ContaPagar contaPagar;

	//bi-directional many-to-one association to ContaReceber
	@ManyToOne
	@JoinColumn(name="id_conta_receber")
	private ContaReceber contaReceber;

	//bi-directional many-to-one association to Lancamento
	@ManyToOne
	@JoinColumn(name="id_lancamento")
	private Lancamento lancamento;

	//bi-directional many-to-one association to Obra
	@ManyToOne
	@JoinColumn(name="id_obra")
	private Obra obra;

	//bi-directional many-to-one association to UnidadeObra
	@ManyToOne
	@JoinColumn(name="id_unidade_obra")
	private UnidadeObra unidadeObra;

	public Anexo() {
	}

	public int getIdAnexo() {
		return this.idAnexo;
	}

	public void setIdAnexo(Integer idAnexo) {
		this.idAnexo = idAnexo;
	}

	public byte[] getArquivo() {
		return this.arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
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

	public Lancamento getLancamento() {
		return this.lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public UnidadeObra getUnidadeObra() {
		return this.unidadeObra;
	}

	public void setUnidadeObra(UnidadeObra unidadeObra) {
		this.unidadeObra = unidadeObra;
	}

}