package com.generation.hallo2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello2")
public class Controller {

	@GetMapping
	public String objetivosAprendizagem() {
		
		return "Aprender Spring boot";
				
	}
	
}