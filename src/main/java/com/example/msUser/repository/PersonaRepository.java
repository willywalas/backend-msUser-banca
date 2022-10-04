package com.example.msUser.repository;

import com.example.msUser.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    @Override
    @Transactional
    Persona save(Persona persona);

    @Transactional(readOnly = true)
    Optional<Persona> findByEmailAndPassword(String email, String password);

    @Override
    @Transactional(readOnly = true)
    List<Persona> findAll();
}
