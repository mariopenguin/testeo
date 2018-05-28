package com.example.demo.interfaces;

import java.sql.Date;

import com.example.demo.clases.Historico;

public interface HistoricoService {
	public Iterable<Historico> getAll();

	public boolean create(Historico historico);

	public Historico getById(Integer id);

	public Iterable<Historico> getByPuesto(String puesto);

	public Iterable<Historico> getByRango(String rango);

	public Iterable<Historico> getByFechaIni(Date fechaIni);

	public Iterable<Historico> getByFechaFin(Date fechaFin);
	
	public Iterable<Historico> getAllByEmpleado(Integer id);

	public boolean update(Historico historico);

	public void delete(Historico historico);
}
