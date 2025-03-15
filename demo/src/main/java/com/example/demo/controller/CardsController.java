package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class CardsController {

@GetMapping("/myCards")
public String getCardsDetails() {
    return "Here are the cards details from the database";
}

}
