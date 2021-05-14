package com.unla.oo22021.services;

import com.unla.oo22021.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personaService")
public interface IPersonaService {
    List<Persona> getAll();
    List<Persona> findAllAndUserWithRoles();
}