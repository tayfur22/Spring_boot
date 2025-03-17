package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users1")
public class SecurityUserController {


    @GetMapping
    public String getUsers(){
        return "Hello World";
    }
}
