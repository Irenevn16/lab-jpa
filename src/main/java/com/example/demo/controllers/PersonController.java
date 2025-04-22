package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.Repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PersonController {
    @Autowired
    private IPersonRepository iPersonRepository;

    @GetMapping("/api/hello")
    public String hello(){
        return "Hola mundo";
    }

    @GetMapping("/api/persons")
    public List<Person> getAllPersons(){
            return iPersonRepository.findAll();
        }

    }

