package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ContactController {

	@GetMapping("/contact")
	public String getContact() {
		return "Inquiry details are Saved in ";
	}

}
