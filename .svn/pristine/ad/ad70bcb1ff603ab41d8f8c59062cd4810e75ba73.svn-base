package com.example.demo.servicios;

import java.io.ByteArrayOutputStream;

//import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.clases.Departamento;
import com.example.demo.comprobaciones.Validar;
import com.example.demo.interfaces.DepartamentoService;
import com.example.demo.repositorios.DepartamentoRepository;
import com.example.demo.utils.JasperReport;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private JasperReport conex;
	@Autowired
	public DepartamentoRepository departamentoRepository;

	// ALL
	@Override
	public Iterable<Departamento> getAll() {

		return departamentoRepository.findAll();
	}

	// AÑADIR
	@Override
	public boolean create(Departamento departamento) {
		if (!Validar.estaVacio(departamento.getNombreDepartamento())
				&& !departamentoRepository.existsByNombreDepartamento(departamento.getNombreDepartamento())) {
			departamentoRepository.save(departamento);
			return true;
		}
		return false;
	}

	// FINDBYID
	@Override
	public Departamento getById(Integer id) {
		if (!Validar.estaVacio(id.toString()) && departamentoRepository.existsById(id)) {

			return departamentoRepository.findById(id);
		}
		return null;
	}

	// FINDBYNAME
	@Override
	public Departamento getByName(String nombre) {
		if (!Validar.estaVacio(nombre) && departamentoRepository.existsByNombreDepartamento(nombre)) {

			return departamentoRepository.findByNombreDepartamento(nombre);
		}
		return null;
	}

	// UPDATE
	@Override
	public boolean update(Departamento departamento) {
		if (!Validar.estaVacio(departamento.getNombreDepartamento())
				&& departamentoRepository.existsById(departamento.getId())
				&& !departamentoRepository.existsByNombreDepartamento(departamento.getNombreDepartamento())) {
			departamentoRepository.save(departamento);
			return true;
		}
		return false;
	}

	// DELETE
	@Override
	public void delete(Departamento departamento) {
		if (!Validar.estaVacio(departamento.getNombreDepartamento())) {
			Departamento d = departamentoRepository.findById(departamento.getId());
			if (d != null) {
				departamentoRepository.delete(d);
			} else {
				System.out.println("no existe ningun departamento con ese nombre");
			}
		}
	}

	@Override
	public byte[] getRptPDF(HttpServletResponse response) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			String jrxmlPdfFileName = "src/main/java/com/example/demo/utils/ReporteDepartamentos.jrxml";
			String jasperPdfFileName = "src/main/java/com/example/demo/utils/ReporteDepartamentos.jasper";
			JasperCompileManager.compileReportToFile(jrxmlPdfFileName, jasperPdfFileName);

			JasperPrint print = JasperFillManager.fillReport(jasperPdfFileName, null, conex.getConn());

			response.addHeader("Content-disposition", " inline; attachment; filename=ReportAll.pdf");
			//ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(print, baos);
			// conex.getConn().close();

		} catch (Exception e) {

		}
		return baos.toByteArray();

	}

}
