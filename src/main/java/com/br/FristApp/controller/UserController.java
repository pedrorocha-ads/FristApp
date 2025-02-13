package com.br.FristApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserController {

    @GetMapping
    public String helloWord(){
        return "Hello Word";
    }
    @GetMapping("/{name}")
    public String helloUser(@PathVariable String name){
        return "Hello " + name + " nice to meet you!!";
    }

}

