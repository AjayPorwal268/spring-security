package com.example.learnspring.controllers;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsController {


    @GetMapping("/demo")
    public String demo() {
        return "login successful";
    }

    @GetMapping("/test")
    public String test() {
        return "test login successful";
    }

    @PostMapping("/test")
    public String testPost() {
        return "test post login successful";
    }
}
