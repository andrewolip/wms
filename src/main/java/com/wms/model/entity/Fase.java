package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fase database table.
 * 
 */
@Entity
@NamedQuery(name="Fase.findAll", query="SELECT f FROM Fase f")
public class Fase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fase")
	private Integer idFase;

	private String descricao;

	@Column(name="nome_fase")
	private String nomeFase;

	//bi-directional many-to-one association to FaseObra
	@OneToMany(mappedBy="fase")
	private List<FaseObra> faseObras;

	public Fase() {
	}

	public Integer getIdFase() {
		return this.idFase;
	}

	public void setIdFase(Integer idFase) {
		this.idFase = idFase;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeFase() {
		return this.nomeFase;
	}

	public void setNomeFase(String nomeFase) {
		this.nomeFase = nomeFase;
	}

	public List<FaseObra> getFaseObras() {
		return this.faseObras;
	}

	public void setFaseObras(List<FaseObra> faseObras) {
		this.faseObras = faseObras;
	}

	public FaseObra addFaseObra(FaseObra faseObra) {
		getFaseObras().add(faseObra);
		faseObra.setFase(this);

		return faseObra;
	}

	public FaseObra removeFaseObra(FaseObra faseObra) {
		getFaseObras().remove(faseObra);
		faseObra.setFase(null);

		return faseObra;
	}

}