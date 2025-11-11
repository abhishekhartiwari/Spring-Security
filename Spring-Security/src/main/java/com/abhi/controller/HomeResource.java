package com.abhi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeResource {
	
	@GetMapping("/home")
	public String home() {
		System.out.println("Inside controller now");
		return("<h1>Welcome Home </h1>");
		
		
	}

}
