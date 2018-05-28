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
import com.example.demo.clases.Formacion;
import com.example.demo.interfaces.FormacionService;

@Controller
@RequestMapping(path = "/formaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class FormacionController {
	@Autowired
	FormacionService formacionService;

	// AÑADIR
	@PostMapping(path = "/add")
	public @ResponseBody Formacion addNewFormacion(@RequestBody Formacion formacion) {
		formacionService.create(formacion);
		return formacion;
	}

	// ELIMINAR
	@DeleteMapping("/eliminar/{id}")
	public void deleteById(@PathVariable Integer id) {
		formacionService.delete(formacionService.getById(id));
	}

	// UPDATE
	@PutMapping("/update/{id}")
	public @ResponseBody boolean updateById(@PathVariable Integer id, @RequestBody Formacion formacion) {
		return formacionService.update(formacion);
	}

	// ALL
	@GetMapping("/all")
	public @ResponseBody Iterable<Formacion> all() {
		return formacionService.getAll();
	}

	// FINDBYID
	@GetMapping("/findbyid/{id}")
	public @ResponseBody Formacion findbyId(@PathVariable int id) {
		return formacionService.getById(id);
	}

	@GetMapping("/findbytipo/{tipo}")
	public @ResponseBody Iterable<Formacion> findbyTipo(@PathVariable String tipo) {
		return formacionService.getAllByTipo(tipo);
	}

	// FINDALLBYID
	@GetMapping("/findallbyid/{id}")
	public @ResponseBody Iterable<Formacion> findAllbyId(@PathVariable int id) {

		return formacionService.getAllByEmpleado(id);
	}
}
