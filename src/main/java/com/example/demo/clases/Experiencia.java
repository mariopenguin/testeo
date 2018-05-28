package com.example.demo.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Experiencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "id_empleado")
	@JsonBackReference
	private Empleado empleadoExperiencia;

	private String empresa;

	private String puesto;

	private String cliente;

	private String tiempo;

	public Empleado getEmpleado() {
		return empleadoExperiencia;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleadoExperiencia = empleado;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Experiencia [id=" + id + ", empleado=" + empleadoExperiencia + ", empresa=" + empresa + ", puesto="
				+ puesto + ", cliente=" + cliente + ", tiempo=" + tiempo + "]";
	}

}
