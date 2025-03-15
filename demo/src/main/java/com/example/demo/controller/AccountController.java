package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AccountController {

@GetMapping("/myAccount")
public String getAccountDetails() {
    return "Here are the account details from the database";
}

}
