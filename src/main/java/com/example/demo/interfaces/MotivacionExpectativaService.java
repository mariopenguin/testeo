package com.example.demo.interfaces;

import com.example.demo.clases.MotivacionExpectativa;

public interface MotivacionExpectativaService {
	public Iterable<MotivacionExpectativa> getAll();

	public boolean create(MotivacionExpectativa motivacionExpectativa);

	public MotivacionExpectativa getById(Integer id);

	public boolean update(MotivacionExpectativa motivacionExpectativa);

	public void delete(MotivacionExpectativa motivacionExpectativa);

	public Iterable<MotivacionExpectativa> getAllById(Integer id);
}
