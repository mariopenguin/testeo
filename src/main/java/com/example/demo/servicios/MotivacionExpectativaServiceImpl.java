package com.example.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.clases.Empleado;
import com.example.demo.clases.MotivacionExpectativa;
import com.example.demo.comprobaciones.Validar;
import com.example.demo.interfaces.MotivacionExpectativaService;
import com.example.demo.repositorios.MotivacionExpectativaRepository;
import com.example.demo.repositorios.EmpleadoRepository;

@Service
public class MotivacionExpectativaServiceImpl implements MotivacionExpectativaService {

	@Autowired
	public MotivacionExpectativaRepository motivacionExpectativaRepository;
	@Autowired
	public EmpleadoRepository empleadoRepository;

	// ALL
	@Override
	public Iterable<MotivacionExpectativa> getAll() {

		return motivacionExpectativaRepository.findAll();
	}

	@Override
	public boolean create(MotivacionExpectativa motivacionExpectativa) {
		if (camposValidos(motivacionExpectativa)
				&& empleadoRepository.existsById(motivacionExpectativa.getEmpleado().getId())) {
			Empleado e = empleadoRepository.findById(motivacionExpectativa.getEmpleado().getId());
			motivacionExpectativa.setEmpleado(e);
			motivacionExpectativaRepository.save(motivacionExpectativa);
			return true;
		}
		return false;
	}

	@Override
	public MotivacionExpectativa getById(Integer id) {
		if (!Validar.estaVacio(id.toString()) && motivacionExpectativaRepository.existsById(id)) {
			return motivacionExpectativaRepository.findById(id);
		}
		return null;
	}

	@Override
	public boolean update(MotivacionExpectativa motivacionExpectativa) {
		if (camposValidos(motivacionExpectativa)
				&& motivacionExpectativaRepository.existsById(motivacionExpectativa.getId())) {
			motivacionExpectativaRepository.save(motivacionExpectativa);
			return true;
		}
		return false;
	}

	@Override
	public void delete(MotivacionExpectativa motivacionExpectativa) {
		if (!Validar.estaVacio(motivacionExpectativa.getEmpleado().getId().toString())) {
			motivacionExpectativaRepository.delete(motivacionExpectativa);
		}
	}

	@Override
	public Iterable<MotivacionExpectativa> getAllById(Integer id) {
		Empleado e = empleadoRepository.findById(id);
		return motivacionExpectativaRepository.findAllByEmpleadoMotivacionExpectativa(e);
	}

	private boolean camposValidos(MotivacionExpectativa motivacionExpectativa) {
		if (!Validar.estaVacio(motivacionExpectativa.getDescripcion()) && motivacionExpectativa.getEmpleado() != null) {
			return true;
		}
		return false;
	}

}
