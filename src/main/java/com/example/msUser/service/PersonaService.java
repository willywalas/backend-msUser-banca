package com.example.msUser.service;

import com.example.msUser.entity.Persona;
import org.springframework.http.ResponseEntity;

public interface PersonaService {
    ResponseEntity<?> createPersona(Persona persona);
    ResponseEntity<?> loginPersona(Persona persona);
    ResponseEntity<?> getAllPersona();
}
