package com.example.demo.clases;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Formacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String tipo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empleado")
	@JsonBackReference
	private Empleado empleadoFormacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Empleado getEmpleado() {
		return empleadoFormacion;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleadoFormacion = empleado;
	}

	public Formacion(String tipo, Empleado empleado) {
		super();
		this.tipo = tipo;
		this.empleadoFormacion = empleado;
	}

	public Formacion() {
		super();
	}

}
