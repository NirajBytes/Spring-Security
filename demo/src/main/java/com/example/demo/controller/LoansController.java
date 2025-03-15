package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class LoansController {

@GetMapping("/myLoans")
public String getLoanDetails() {
    return "Here are the loan details from the database";
}

}
