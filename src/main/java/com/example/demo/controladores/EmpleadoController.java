package com.example.demo.controladores;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.clases.Empleado;
import com.example.demo.interfaces.EmpleadoService;
import com.example.demo.interfaces.ExcelService;

@Controller
@RequestMapping(path = "/empleados")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {

	@Autowired
	public EmpleadoService empleadoService;
	@Autowired
	public ExcelService excelService;

	// AÑADIR
	@PostMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody Empleado add(@RequestBody Empleado emp) {
		empleadoService.create(emp);
		return emp;
	}

	// ELIMINAR
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody void delete(@PathVariable Integer id) {

		empleadoService.delete(empleadoService.getById(id));

	}

	// UPDATE
	@PutMapping("/update/{id}")
	public @ResponseBody boolean update(@PathVariable Integer id, @RequestBody Empleado emp) {

		return empleadoService.update(emp);
	}

	// ALL
	@GetMapping("/all")
	public @ResponseBody Iterable<Empleado> all() {

		return empleadoService.getAll();

	}

	// FINDBYID
	@GetMapping("/findbyid/{id}")
	public @ResponseBody Empleado findbyId(@PathVariable Integer id) {

		return empleadoService.getById(id);
	}

	// FINDBYEMAIL
	@GetMapping("/findbyemail/{email}")
	public @ResponseBody Empleado findbyEmail(@PathVariable String email) {

		return empleadoService.getByEmail(email);
	}

	// FINDBYDNI
	// FINDBYNAME
	@GetMapping("/findbydni/{dni}")
	public @ResponseBody Empleado findbyDni(@PathVariable String dni) {

		return empleadoService.getByDni(dni);
	}

	// FINDBYDEPARTAMENTO
	@GetMapping("/findbydepartamento/{idDep}")
	public @ResponseBody Iterable<Empleado> findbyDepartamento(@PathVariable Integer idDep) {
		return empleadoService.getByDepartamento(idDep);
	}

	@GetMapping(path = "/report/pdf")
	public @ResponseBody byte[] getRptPDF(HttpServletResponse response) {
		return this.empleadoService.getRptPDF(response);
	}
	
	@GetMapping(path = "/downloadexcel")
	public @ResponseBody void getExcel(HttpServletResponse response)  {
		excelService.getExcel(response);
	}
	
}
