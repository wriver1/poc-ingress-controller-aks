package com.bancodebogota.testingresscontroller.cliente2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bancodebogota.testingresscontroller.cliente2.service.Cliente1Service;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
@RequestMapping("/api")
public class Cliente2 {
	
	@Autowired
	private Cliente1Service service;
	
	@GetMapping("/saludarCliente1")
	public ResponseEntity<?> saludarCliente2() {
		
		try {
			return new ResponseEntity<String>(service.saludarCliente1(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/saludo")
	public ResponseEntity<String> saludo() {
		return new ResponseEntity<String>("Hola soy el Cliente 2, ¿cómo estás?", HttpStatus.OK);
	}

}
