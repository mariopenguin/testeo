package com.example.demo.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MotivacionExpectativa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "id_empleado")
	@JsonBackReference
	private Empleado empleadoMotivacionExpectativa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Empleado getEmpleado() {
		return empleadoMotivacionExpectativa;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleadoMotivacionExpectativa = empleado;
	}

	public MotivacionExpectativa(String descripcion, Empleado empleado) {
		super();
		this.descripcion = descripcion;
		this.empleadoMotivacionExpectativa = empleado;
	}

	public MotivacionExpectativa() {
		super();
	}

}
