package com.example.demo.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Titulacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String centro;
	private String especialidad;

	@OneToOne
	@JoinColumn(name = "id_empleado", unique = true)
	@JsonBackReference
	private Empleado empleadoTitulacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Empleado getEmpleadoTitulacion() {
		return empleadoTitulacion;
	}

	public void setEmpleadoTitulacion(Empleado empleadoTitulacion) {
		this.empleadoTitulacion = empleadoTitulacion;
	}

}
