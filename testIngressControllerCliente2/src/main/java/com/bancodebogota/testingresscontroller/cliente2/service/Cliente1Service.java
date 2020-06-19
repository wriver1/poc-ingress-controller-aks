package com.bancodebogota.testingresscontroller.cliente2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Cliente1Service {
	
	@Value("#{systemEnvironment['CLIENTE1_ENDPOINT']}")
	private String CLIENTE1_ENDPOINT;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String saludarCliente1() throws Exception {
		
		String saludo = null;
	
		if( CLIENTE1_ENDPOINT == null || "".equals(CLIENTE1_ENDPOINT.trim()))
			throw new IllegalStateException("No se pudo leer el endpoint del rest Cliente 1. Por favor configurar.");
		
		try {
			saludo = restTemplate.getForObject(this.CLIENTE1_ENDPOINT + "/saludo", String.class);
			return saludo;
		} catch (Exception e) {
			throw new Exception("Ocurrió un problema al saludar al cliente 1: " + e.getMessage(), e);
		}
		
	}

}
