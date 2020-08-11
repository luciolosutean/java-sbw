package com.arobs.sbw.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/", produces = "application/json")
    public String index() {
        return "{\"title\": \"Greetings from Spring Boot Arobs!\"}";
    }
}
