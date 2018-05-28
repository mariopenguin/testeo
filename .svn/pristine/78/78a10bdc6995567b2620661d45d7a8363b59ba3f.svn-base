package com.example.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.clases.Empleado;
import com.example.demo.clases.Formacion;
import com.example.demo.interfaces.FormacionService;
import com.example.demo.repositorios.EmpleadoRepository;
import com.example.demo.repositorios.FormacionRepository;
import com.example.demo.comprobaciones.Validar;

@Service
public class FormacionServiceImpl implements FormacionService {
	@Autowired
	public FormacionRepository formacionRepository;

	@Autowired
	public EmpleadoRepository empleadoRepository;

	public boolean create(Formacion formacion) {
		if (camposValidos(formacion) && empleadoRepository.existsById(formacion.getEmpleado().getId())) {
			Empleado e = empleadoRepository.findById(formacion.getEmpleado().getId());
			formacion.setEmpleado(e);
			formacionRepository.save(formacion);
			return true;
		}
		return false;
	}

	public boolean update(Formacion formacion) {
		if (!Validar.estaVacio(formacion.getEmpleado().getId().toString())
				&& formacionRepository.existsById(formacion.getId())) {
			if (camposValidos(formacion)) {
				formacionRepository.save(formacion);
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterable<Formacion> getAll() {
		return formacionRepository.findAll();
	}

	@Override
	public Formacion getById(Integer id) {
		if (!Validar.estaVacio(id.toString()) && formacionRepository.existsById(id)) {
			return formacionRepository.findById(id);
		}
		return null;
	}

	@Override
	public void delete(Formacion formacion) {
		if (!Validar.estaVacio(formacion.getId().toString())) {
			formacionRepository.delete(formacion);
		}
	}

	@Override
	public Iterable<Formacion> getAllByTipo(String tipo) {
		return formacionRepository.findAllByTipo(tipo);
	}

	private boolean camposValidos(Formacion formacion) {
		if (!Validar.estaVacio(formacion.getTipo()) && formacion.getEmpleado() != null
				&& !Validar.estaVacio(formacion.getId().toString())) {
			return true;
		}
		return false;
	}

	@Override
	public Iterable<Formacion> getAllByEmpleado(int id) {
		Empleado e = empleadoRepository.findById(id);
		return formacionRepository.findAllByEmpleadoFormacion(e);
	}

}
