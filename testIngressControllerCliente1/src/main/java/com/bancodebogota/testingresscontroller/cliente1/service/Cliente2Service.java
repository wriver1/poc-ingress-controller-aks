package com.bancodebogota.testingresscontroller.cliente1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Cliente2Service {

	@Value("#{systemEnvironment['CLIENTE2_ENDPOINT']}")
	private String CLIENTE2_ENDPOINT;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String saludarCliente2() throws Exception {
		
		String saludo = null;
	
		if( CLIENTE2_ENDPOINT == null || "".equals(CLIENTE2_ENDPOINT.trim()))
			throw new IllegalStateException("No se pudo leer el endpoint del rest Cliente 2. Por favor configurar.");
		
		try {
			saludo = restTemplate.getForObject(this.CLIENTE2_ENDPOINT + "/cliente2/api/saludo", String.class);
			return saludo;
		} catch (Exception e) {
			throw new Exception("Ocurrió un problema al saludar al cliente 2: " + e.getMessage(), e);
		}
		
	}

}
