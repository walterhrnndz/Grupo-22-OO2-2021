package com.unla.oo22021.services.implementation;

import com.unla.oo22021.entities.Persona;
import com.unla.oo22021.repositories.IPersonaRepository;
import com.unla.oo22021.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personaService")
public class PersonaService implements IPersonaService {

    @Autowired
    @Qualifier("personaRepository")
    private IPersonaRepository personaRepository;

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public List<Persona> findAllAndUserWithRoles() {
        return personaRepository.findAllAndUserWithRoles();
    }
}