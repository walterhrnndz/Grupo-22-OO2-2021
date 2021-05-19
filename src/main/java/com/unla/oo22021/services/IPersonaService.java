package com.unla.oo22021.services;

import com.unla.oo22021.entities.Persona;
import com.unla.oo22021.models.PersonaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personaService")
public interface IPersonaService {
    List<Persona> getAll();
    List<Persona> findAllAndUserWithRoles();

    boolean remove(int id);
    PersonaModel insertOrUpdate(PersonaModel personaModel);

    Persona findByNroDni(String  nroDNI);
    Persona findByEmail(String mail);
}