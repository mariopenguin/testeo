package com.example.demo.controladores;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.clases.Departamento;
import com.example.demo.interfaces.DepartamentoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

	@Autowired
	public DepartamentoService departamentoService;

	// AÑADIR
	@PostMapping(path = "/add")
	public @ResponseBody Departamento addNewDepartment(@RequestBody Departamento dep) {

		departamentoService.create(dep);

		return dep;
	}

	// ELIMINAR
	@DeleteMapping("/eliminar/{id}")
	public void deleteById(@PathVariable Integer id) {

		departamentoService.delete(departamentoService.getById(id));

	}

	// UPDATE
	@PutMapping("/update/{id}")
	public @ResponseBody boolean updateById(@PathVariable Integer id, @RequestBody Departamento departamento) {
		return departamentoService.update(departamento);

	}

	// ALL
	@GetMapping("/all")
	public @ResponseBody Iterable<Departamento> all() {

		return departamentoService.getAll();

	}

	// FINDBYNAME
	@GetMapping("/findbyname/{nombre}")
	public @ResponseBody Departamento findbyName(@PathVariable String nombre) {

		return departamentoService.getByName(nombre);
	}

	// FINDBYID
	@GetMapping("/findbyid/{id}")
	public @ResponseBody Departamento findbyId(@PathVariable int id) {

		return departamentoService.getById(id);
	}

	@GetMapping(path = "/report/pdf")
	public @ResponseBody byte[] getRptPDF(HttpServletResponse response) {
		return this.departamentoService.getRptPDF(response);
	}
}
