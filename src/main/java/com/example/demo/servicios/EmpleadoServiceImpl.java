package com.example.demo.servicios;

import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.clases.Empleado;
import com.example.demo.comprobaciones.Validar;
import com.example.demo.interfaces.EmpleadoService;
import com.example.demo.repositorios.DepartamentoRepository;
import com.example.demo.repositorios.EmpleadoRepository;
import com.example.demo.repositorios.TitulacionRepository;
import com.example.demo.utils.JasperReport;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private JasperReport conex;
	@Autowired
	public EmpleadoRepository empleadoRepository;
	@Autowired
	public TitulacionRepository titulacionRepository;
	@Autowired
	public DepartamentoRepository departamentoRepository;

	// ALL
	@Override
	public Iterable<Empleado> getAll() {

		return empleadoRepository.findAll();
	}

	// CREATE
	@Override
	public boolean create(Empleado empleado) {
		if (empleadoCorrecto(empleado) && !empleadoRepository.existsByDni(empleado.getDni())) {
			if (departamentoRepository.existsByNombreDepartamento(empleado.getDepartamento().getNombreDepartamento())) {
				empleadoRepository.save(empleado);
				return true;
			}
		}
		return false;
	}

	// GETBYID
	@Override
	public Empleado getById(Integer id) {
		if (!Validar.estaVacio(id.toString()) && empleadoRepository.existsById(id)) {

			return empleadoRepository.findById(id);
		}
		return null;
	}

	// GETBYEMAIL 
	@Override
	public Empleado getByEmail(String nombre) {
		if (!Validar.estaVacio(nombre) && empleadoRepository.existsByEmail(nombre)) {

			return empleadoRepository.findByEmail(nombre);
		}
		return null;
	}

	// GETBYDNI
	@Override
	public Empleado getByDni(String dni) {
		if (Validar.dniCorrecto(dni) && empleadoRepository.existsByDni(dni)) {

			return empleadoRepository.findByDni(dni);
		}
		return null;
	}

	// ACTUALIZAR
	@Override
	public boolean update(Empleado empleado) {
		if (empleadoCorrecto(empleado) && empleadoRepository.existsById(empleado.getId())) {
			if (empleadoCorrecto(empleado)) {
				empleadoRepository.save(empleado);
				return true;
			}
		}
		return false;
	}

	// BORRAR
	@Override
	public void delete(Empleado empleado) {
		if (!Validar.estaVacio(empleado.getDni())) {
			empleadoRepository.delete(empleado);
		}

	}

	// Validaciones

	private boolean empleadoCorrecto(Empleado empleado) {

		if (!Validar.estaVacio(empleado.getNombre()) && !Validar.estaVacio(empleado.getPrimerApellido())
				&& !Validar.estaVacio(empleado.getSegundoApellido()) && Validar.emailCorrecto(empleado.getEmail())
				&& !Validar.estaVacio(empleado.getDireccion()) && !Validar.estaVacio(empleado.getPuestoActual())
				&& Validar.telefonoCorrecto(empleado.getTelefono()) && empleado.getDepartamento() != null
				&& Validar.dniCorrecto(empleado.getDni())) {
			return true;
		}
		return false;
	}

	@Override
	public Iterable<Empleado> getByDepartamento(Integer idDep) {
		return empleadoRepository.findAllByDepartamento(departamentoRepository.findById(idDep));
	}

	@Override
	public byte[] getRptPDF(HttpServletResponse response) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			String jrxmlPdfFileName = "src/main/java/com/example/demo/utils/ReporteEmpleados.jrxml";
			String jasperPdfFileName = "src/main/java/com/example/demo/utils/ReporteEmpleados.jasper";
			JasperCompileManager.compileReportToFile(jrxmlPdfFileName, jasperPdfFileName);

			JasperPrint print = JasperFillManager.fillReport(jasperPdfFileName, null, conex.getConn());

			response.addHeader("Content-disposition", " inline; attachment; filename=ReportDelegations.pdf");
			// ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(print, baos);
			// conex.getConn().close();
				
		} catch (Exception e) {

		}
		return baos.toByteArray();
	}

}
