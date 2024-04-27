package com.example.learnspring.controllers;

import com.example.learnspring.httpbody.User;
import com.example.learnspring.services.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserDetailsController {

    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;
    @GetMapping("/users")
    public void getUserList() {
        var u = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(u);
        u.getAuthorities().forEach(a -> System.out.println(a.getAuthority()));
        //return jpaUserDetailsService.getUserList();
    }
    @GetMapping("/login")
    public String login() {
        return "login successful";
    }

}
