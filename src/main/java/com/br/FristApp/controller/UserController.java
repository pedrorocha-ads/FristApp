package com.br.FristApp.controller;

import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/hello")
        public String hello(@RequestParam(name = "nome")String nome){
            return "Hello " + nome + " nice to meet you!!";

    }
}

