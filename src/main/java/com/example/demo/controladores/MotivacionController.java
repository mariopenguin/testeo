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

import com.example.demo.clases.MotivacionExpectativa;
import com.example.demo.interfaces.MotivacionExpectativaService;

@Controller
@RequestMapping(path = "/motivaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class MotivacionController {

	@Autowired
	MotivacionExpectativaService motivacionExpectativaService;

	// AÑADIR
	@PostMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody MotivacionExpectativa addNew(@RequestBody MotivacionExpectativa motivacionExpectativa) {

		motivacionExpectativaService.create(motivacionExpectativa);

		return motivacionExpectativa;
	}

	// ELIMINAR
	@DeleteMapping("/eliminar/{id}")
	public void delete(@PathVariable Integer id) {

		motivacionExpectativaService.delete(motivacionExpectativaService.getById(id));
	}

	// UPDATE
	@PutMapping("/update/{id}")
	public @ResponseBody boolean update(@PathVariable Integer id, @RequestBody MotivacionExpectativa motivacion) {
		return motivacionExpectativaService.update(motivacion);
	}

	// ALL
	@GetMapping("/all")
	public @ResponseBody Iterable<MotivacionExpectativa> all() {
		return motivacionExpectativaService.getAll();

	}

	// FINDBYID
	@GetMapping("/findbyid/{id}")
	public @ResponseBody MotivacionExpectativa findbyId(@PathVariable Integer id) {

		return motivacionExpectativaService.getById(id);
	}

	// FINDBYID
	@GetMapping("/findallbyid/{id}")
	public @ResponseBody Iterable<MotivacionExpectativa> findAllbyId(@PathVariable Integer id) {

		return motivacionExpectativaService.getAllById(id);
	}

}
