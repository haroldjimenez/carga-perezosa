package com.techandsolve.cargaperezosa.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ejecucion_log")
@SequenceGenerator(name = "ID_SEQUENCIA", sequenceName = "carga_perezosa_ejecuciones_id_seq", allocationSize = 1)
public class Ejecuciones {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQUENCIA")
	private Long id;
	
	@Column(name = "documento_identidad")
	private String documentoIdentidad;
	
	@Column(name = "fecha_ejecucion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEjecucion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}
}
