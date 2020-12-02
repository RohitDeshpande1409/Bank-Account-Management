package com.app.bankmanagement.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funRestController {
	
	@GetMapping("/")
	public String sayHello(){
		return "Hello world Time on server is "+ LocalDateTime.now();
	}

}
