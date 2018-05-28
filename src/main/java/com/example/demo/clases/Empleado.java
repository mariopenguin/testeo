package com.example.demo.clases;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	private String primerApellido;

	private String segundoApellido;

	private String direccion;

	private String telefono;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String dni;

	private String puestoActual;

	// private BufferedImage foto;

	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "empleadoTitulacion")
	@JsonManagedReference
	private Titulacion titulacion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoFormacion")
	@JsonManagedReference
	private Set<Formacion> formaciones;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoExperiencia")
	@JsonManagedReference
	private Set<Experiencia> experiencias;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoMotivacionExpectativa")
	@JsonManagedReference
	private Set<MotivacionExpectativa> motivacionesExpectativas;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoHistorico")
	@JsonManagedReference
	private Set<Historico> historicos;

	public Set<MotivacionExpectativa> getMotivacionesExpectativas() {
		return motivacionesExpectativas;
	}

	public void setMotivacionesExpectativas(Set<MotivacionExpectativa> motivacionesExpectativas) {
		this.motivacionesExpectativas = motivacionesExpectativas;
	}

	public Empleado() {
		this.experiencias = new HashSet<>();
		this.formaciones = new HashSet<>();
		this.motivacionesExpectativas = new HashSet<>();
		this.historicos = new HashSet<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	public Set<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(Set<Historico> historicos) {
		this.historicos = historicos;
	}

	public Set<Formacion> getFormaciones() {
		return formaciones;
	}

	public void setFormaciones(Set<Formacion> formaciones) {
		this.formaciones = formaciones;
	}

	public Set<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(Set<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	public String getPuestoActual() {
		return puestoActual;
	}

	public void setPuestoActual(String puestoActual) {
		this.puestoActual = puestoActual;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
