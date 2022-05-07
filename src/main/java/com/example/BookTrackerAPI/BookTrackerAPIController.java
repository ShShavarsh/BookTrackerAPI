package com.example.BookTrackerAPI;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookTrackerAPIController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
}
