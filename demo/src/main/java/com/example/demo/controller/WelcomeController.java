package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class WelcomeController {

@GetMapping("/welcome")
public String getMethodName() {
    return "welcome to application with Security";
}

}
