package com.api.Greetings.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

	
	
	@RequestMapping("/current")
	public String currentGreeting(){
		return  "goodeveing all eclipses";
	}
}
