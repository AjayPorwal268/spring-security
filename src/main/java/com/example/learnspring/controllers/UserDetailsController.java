package com.example.learnspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsController {


    @GetMapping("/demo")
    public String demo() {
        return "login successful";
    }
}
