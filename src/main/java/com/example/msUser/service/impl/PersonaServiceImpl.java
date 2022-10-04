package com.example.msUser.service.impl;

import com.example.msUser.entity.Persona;
import com.example.msUser.repository.PersonaRepository;
import com.example.msUser.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public ResponseEntity<?> createPersona(Persona persona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaRepository.save(persona));
    }

    @Override
    public ResponseEntity<?> loginPersona(Persona persona) {
        Optional<Persona> oPersona=personaRepository.findByEmailAndPassword(persona.getEmail(),persona.getPassword());
        if(!oPersona.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oPersona);
    }
    @Override
    public ResponseEntity<?> getAllPersona() {
        List<Persona> personas= StreamSupport.stream(personaRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return new ResponseEntity<>(personas,HttpStatus.OK);
    }
}
