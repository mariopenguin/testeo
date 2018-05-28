package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.clases.Empleado;
import com.example.demo.clases.Titulacion;

public interface TitulacionRepository extends CrudRepository<Titulacion, Long> {

	@Query
	public Titulacion findById(int id);

	@Query
	public Titulacion findByEmpleadoTitulacion(Empleado empleado);

	@Query
	public boolean existsById(Integer id);

	@Query
	public Iterable<Titulacion> findAllByEspecialidad(String especialidad);
}