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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_comentario")
	private int idComentario;

	@Column(name="obra_numero_contrato")
	private int obraNumeroContrato;

	//bi-directional many-to-one association to Obra
	@ManyToOne
	private Obra obra;

	public ComentarioObra() {
	}

	public int getIdComentario() {
		return this.idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public int getObraNumeroContrato() {
		return this.obraNumeroContrato;
	}

	public void setObraNumeroContrato(int obraNumeroContrato) {
		this.obraNumeroContrato = obraNumeroContrato;
	}

	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

}