package com.example.demo.interfaces;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.clases.Empleado;

public interface EmpleadoService {
	public Iterable<Empleado> getAll();

	public boolean create(Empleado empleado);

	public Empleado getById(Integer id);

	public Iterable<Empleado> getByDepartamento(Integer idDep);

	public Empleado getByEmail(String email);

	public Empleado getByDni(String dni);

	public boolean update(Empleado empleado);

	public void delete(Empleado empleado);

	public byte[] getRptPDF(HttpServletResponse response);
}
