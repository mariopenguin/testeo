package com.example.demo.interfaces;

import com.example.demo.clases.Experiencia;

public interface ExperienciaService {
	public Iterable<Experiencia> getAll();

	public boolean create(Experiencia experiencia);

	public Experiencia getById(Integer id);

	public boolean update(Experiencia experiencia);

	public void delete(Experiencia experiencia);
	
	public Iterable<Experiencia> getAllByEmpleado(Integer id);
}
