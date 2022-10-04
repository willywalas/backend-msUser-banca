package com.example.msUser.controller;

import com.example.msUser.entity.Persona;
import com.example.msUser.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Persona persona){
        ResponseEntity<?>responseEntity=null;

        try {
            responseEntity=personaService.createPersona(persona);
        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);;
        }
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/login")
    @PostMapping
    public ResponseEntity<?> login(@RequestBody Persona persona){
        ResponseEntity<?>responseEntity=null;

        try {
            responseEntity=personaService.loginPersona(persona);
        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);;
        }
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> readAll(){
        ResponseEntity<?>responseEntity=null;
        try {
            responseEntity=personaService.getAllPersona();
        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
