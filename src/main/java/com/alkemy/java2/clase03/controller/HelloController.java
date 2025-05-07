package com.alkemy.java2.clase03.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("¡Hola desde la API RESTful!");
  }
}
