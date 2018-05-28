package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.clases.Empleado;
import com.example.demo.clases.Experiencia;
import com.example.demo.clases.Formacion;

public interface FormacionRepository extends CrudRepository<Formacion, Long> {

	@Query
	public Formacion findByEmpleadoFormacion(Empleado empleado);

	@Query
	public Formacion findById(Integer id);

	@Query
	public boolean existsById(Integer id);

	@Query
	public Iterable<Formacion> findAllByTipo(String tipo);
	@Query
	public Iterable<Formacion> findAllByEmpleadoFormacion(Empleado empleado);
}