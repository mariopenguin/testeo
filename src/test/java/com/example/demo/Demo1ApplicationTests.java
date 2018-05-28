package com.example.demo;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.clases.Empleado;
import com.example.demo.comprobaciones.Validar;
import com.example.demo.servicios.EmpleadoServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {
	EmpleadoServiceImpl em = new EmpleadoServiceImpl();

	@Test
	public void testviewByEmail() {
		String email = "zo4j2mpc6f@hotmail.co.uk";
		Empleado miEm= em.getByEmail(email);
		assertNull(miEm);
	}

	@Test
	public void probarVacio() {
		// true=ok!
		String vacio = "";
		assertTrue(Validar.estaVacio(vacio));
	}

	@Test
	public void probarLleno() {
		// false=ok!
		String lleno = "asdasdasd";
		assertTrue(Validar.estaVacio(lleno));
	}

	@Test
	public void probarDni() {
		// true=ok!
		String dni = "84005443J";
		String dni1 = "19875340M";
		String dni2 = "15387464G";
		assertTrue(Validar.dniCorrecto(dni));
		assertTrue(Validar.dniCorrecto(dni1));
		assertTrue(Validar.dniCorrecto(dni2));
	}

	@Test
	public void probarDniMal() {
		// false=ok!
		String dni = "84005443A";
		String dni1 = "19875340Ñ";
		String dni2 = "1538464G";
		assertTrue(Validar.dniCorrecto(dni));
		assertTrue(Validar.dniCorrecto(dni1));
		assertTrue(Validar.dniCorrecto(dni2));
	}

	@Test
	public void probarEmail() {
		// true=ok!
		String email = "qwe@qwewqe.com";
		String email2 = "oposfd@gmail.com";
		String email3 = "qwe_32_osdkf@metrica.estudiantes.es";
		assertTrue(Validar.emailCorrecto(email));
		assertTrue(Validar.emailCorrecto(email2));
		assertTrue(Validar.emailCorrecto(email3));
	}

	@Test
	public void probarEmailMal() {
		// false=ok!
		String email = "qwe@qwewqe,com";
		String email2 = "http://foo.co.uk/";
		String email3 = "asd@asdasd..com";
		assertTrue(Validar.emailCorrecto(email));
		assertTrue(Validar.emailCorrecto(email2));
		assertTrue(Validar.emailCorrecto(email3));
	}
}
