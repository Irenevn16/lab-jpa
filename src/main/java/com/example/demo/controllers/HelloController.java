package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ya le estoy indicando a mi app que es un controlador REST (de rest API)
public class HelloController {
    @GetMapping("/hello") // esta anotación indica que el siguiente método manejará un
    // GET al endpoint /hello
    public String hello(){
        return "Hola mundo desde mi API rest";
    }

}