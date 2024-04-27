package com.example.learnspring.httpbody;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {
    private String name;

    private String password;
}
