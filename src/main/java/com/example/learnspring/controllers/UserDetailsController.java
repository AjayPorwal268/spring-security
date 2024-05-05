package com.example.learnspring.controllers;

import com.example.learnspring.security.PreAuthorizedConditionBean;
import jakarta.annotation.PostConstruct;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsController {


    @GetMapping("/demo")
    @PreAuthorize("hasAuthority('read')")
    public String demo() {
        return "login successful";
    }

    @GetMapping("/demo1")
    @PreAuthorize("hasAuthority('write')")
    public String demo1() {
        return "login successful";
    }

    @GetMapping("/demo2/{smth}")
    @PreAuthorize("#something == authentication.name") // authentication.name is form spring security context
    public String demo2(@PathVariable("smth") String something) {
        return "login something successful";
    }

    @GetMapping("/demo3/{smth}")
    @PreAuthorize("@preAuthorizedConditionBean.computeCondition(#something)") // authentication.name is form spring security context
    public String demo3(@PathVariable("smth") String something) {
        return "login conditional bean successful";
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
