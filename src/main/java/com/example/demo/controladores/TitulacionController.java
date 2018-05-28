package com.example.demo.controladores;

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

import com.example.demo.clases.Titulacion;
import com.example.demo.interfaces.TitulacionService;

@Controller
@RequestMapping(path = "/titulaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class TitulacionController {
	@Autowired
	TitulacionService titulacionService;

	// AÑADIR
	@PostMapping(path = "/add")
	public @ResponseBody Titulacion addNewTitulacion(@RequestBody Titulacion titulacion) {
		titulacionService.create(titulacion);
		return titulacion;
	}

	// ELIMINAR
	@DeleteMapping("/eliminar/{id}")
	public void deleteById(@PathVariable Integer id) {

		titulacionService.delete(titulacionService.getById(id));

	}

	// UPDATE
	@PutMapping("/update/{id}")
	public @ResponseBody boolean updateById(@PathVariable Integer id, @RequestBody Titulacion titulacion) {

		return titulacionService.update(titulacion);

	}

	// ALL
	@GetMapping("/all")
	public @ResponseBody Iterable<Titulacion> all() {

		return titulacionService.getAll();

	}

	// FINDBYID
	@GetMapping("/findById/{id}")
	public @ResponseBody Titulacion findbyId(@PathVariable int id) {

		return titulacionService.getById(id);
	}
	
	// FINDBYEMPLEADO
	@GetMapping("/findbyempleado/{id}")
	public @ResponseBody Titulacion findbyEmpleado(@PathVariable Integer id) {

		return titulacionService.getByEmpleadoTitulacion(id);
	}

}
