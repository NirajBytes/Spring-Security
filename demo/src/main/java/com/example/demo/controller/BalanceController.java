package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BalanceController {

	@GetMapping("/myBalance")
	public String getBalanceDetails() {
		return "Here are the balance details from the database";
	}

}
