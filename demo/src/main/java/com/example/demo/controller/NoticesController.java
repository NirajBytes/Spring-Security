package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class NoticesController {

@GetMapping("/notices")
public String getNotices() {
    return "Here are the notices from the database";
}
}
