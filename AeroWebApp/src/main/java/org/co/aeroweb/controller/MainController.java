package org.co.aeroweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = "/")
	private String index() {
		return "index";
	}
	
	@RequestMapping("/cliente")
	public String cliente() {
		return "maestros/cliente/listar";
	}
	
	@RequestMapping("/destino")
	public String destino() {
		return "maestros/destino/listar";
	}
	
	@RequestMapping("/tarifa")
	public String tarifa() {
		return "maestros/tarifa/listar";
	}
	
	@RequestMapping("/vuelo")
	public String vuelo() {
		return "procesos/vuelo/listar";
	}

}
