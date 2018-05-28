package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.clases.Departamento;
import com.example.demo.clases.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

	@Query
	public Empleado findByEmail(String nombre);

	@Query
	public Empleado findByDni(String dni);

	@Query
	public Empleado findById(Integer id);

	@Query
	public Iterable<Empleado> findAllByDepartamento(Departamento dep);

	@Query
	public boolean existsByEmail(String email);

	@Query
	public boolean existsByNombre(String name);

	@Query
	public boolean existsById(Integer id);

	@Query
	public Empleado findByNombre(String name);

	@Query
	public boolean existsByDni(String dni);
}