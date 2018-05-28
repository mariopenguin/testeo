package com.example.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.clases.Empleado;
import com.example.demo.clases.Experiencia;
import com.example.demo.comprobaciones.Validar;
import com.example.demo.interfaces.ExperienciaService;
import com.example.demo.repositorios.EmpleadoRepository;
import com.example.demo.repositorios.ExperienciaRepository;

@Service
public class ExperienciaServiceImpl implements ExperienciaService {
	@Autowired
	public ExperienciaRepository experienciaRepository;

	@Autowired
	public EmpleadoRepository empleadoRepository;

	public boolean create(Experiencia experiencia) {
		if (!Validar.estaVacio(experiencia.getEmpleado().getId().toString())
				&& empleadoRepository.existsById(experiencia.getEmpleado().getId())) {
			if (camposValidos(experiencia)) {
				Empleado e = empleadoRepository.findById(experiencia.getEmpleado().getId());
				experiencia.setEmpleado(e);
				experienciaRepository.save(experiencia);
				return true;
			}
		}
		return false;
	}

	public Iterable<Experiencia> getAll() {
		return experienciaRepository.findAll();
	}

	public boolean update(Experiencia experiencia) {
		if (!Validar.estaVacio(experiencia.getEmpleado().getId().toString())
				&& experienciaRepository.existsById(experiencia.getId())) {
			if (camposValidos(experiencia)) {
				experienciaRepository.save(experiencia);
				return true;
			}
		}
		return false;
	}

	public void delete(Experiencia experiencia) {
		if (!Validar.estaVacio(experiencia.getEmpleado().getId().toString())) {
			experienciaRepository.delete(experiencia);
		}
	}

	@Override
	public Experiencia getById(Integer id) {
		if (!Validar.estaVacio(id.toString()) && experienciaRepository.existsById(id)) {
			return experienciaRepository.findById(id);
		}
		return null;
	}

	private boolean camposValidos(Experiencia experiencia) {
		if (!Validar.estaVacio(experiencia.getCliente()) && !Validar.estaVacio(experiencia.getEmpresa())
				&& !Validar.estaVacio(experiencia.getPuesto()) && !Validar.estaVacio(experiencia.getTiempo())
				&& experiencia.getEmpleado() != null) {
			return true;
		}
		return false;
	}

	@Override
	public Iterable<Experiencia> getAllByEmpleado(Integer id) {
		Empleado e = empleadoRepository.findById(id);
		return experienciaRepository.findAllByEmpleadoExperiencia(e);
	}

}
