package com.example.demo.interfaces;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.clases.Departamento;

public interface DepartamentoService {
	public Iterable<Departamento> getAll();

	public boolean create(Departamento departamento);

	public Departamento getById(Integer id);

	public Departamento getByName(String nombre);

	public boolean update(Departamento departamento);

	public void delete(Departamento departamento);

	public byte[] getRptPDF(HttpServletResponse response);

}
