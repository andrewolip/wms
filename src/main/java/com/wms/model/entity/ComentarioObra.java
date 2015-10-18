package com.wms.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comentario_obra database table.
 * 
 */
@Entity
@Table(name="comentario_obra")
@NamedQuery(name="ComentarioObra.findAll", query="SELECT c FROM ComentarioObra c")
public class ComentarioObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comentario")
	private Integer idComentario;

	@Column(name="obra_numero_contrato")
	private Integer obraNumeroContrato;

	//bi-directional many-to-one association to Obra
	@ManyToOne
	private Obra obra;

	public ComentarioObra() {
	}

	public Integer getIdComentario() {
		return this.idComentario;
	}

	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}

	public Integer getObraNumeroContrato() {
		return this.obraNumeroContrato;
	}

	public void setObraNumeroContrato(Integer obraNumeroContrato) {
		this.obraNumeroContrato = obraNumeroContrato;
	}

	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

}