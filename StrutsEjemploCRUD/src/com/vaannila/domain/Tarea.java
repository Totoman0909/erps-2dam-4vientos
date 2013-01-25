package com.vaannila.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tarea")
public class Tarea {

	private Long id;
	private String nombre;
	private String descripcion;
	private Boolean hecha;
	private Integer tipoTarea;
	
	@Id
	@GeneratedValue
	@Column(name="id")	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="descripcion")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name="hecha")
	public Boolean getHecha() {
		return hecha;
	}
	public void setHecha(Boolean hecha) {
		this.hecha = hecha;
	}
	
	@Column(name="tipo_tarea")
	public Integer getTipoTarea() {
		return tipoTarea;
	}
	public void setTipoTarea(Integer tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

}
