package com.unla.oo22021.services.implementation;

import com.unla.oo22021.converters.PersonaConverter;
import com.unla.oo22021.converters.UserConverter;
import com.unla.oo22021.entities.Persona;
import com.unla.oo22021.entities.User;
import com.unla.oo22021.models.PersonaModel;
import com.unla.oo22021.models.UserModel;
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

    @Autowired
    @Qualifier("personaConverter")
    private PersonaConverter personaConverter;

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public List<Persona> findAllAndUserWithRoles() {
        return personaRepository.findAllAndUserWithRoles();
    }

    @Override
    public boolean remove(int id) {
        try {
            personaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PersonaModel insertOrUpdate(PersonaModel personaModel) {
        return personaConverter.entityToModel(personaRepository.save(personaConverter.modelToEntity(personaModel)));
    }

    @Override
    public Persona findByNroDni(String nroDNI) {
        return personaRepository.findByNroDni(nroDNI);
    }

    @Override
    public Persona findByEmail(String mail) {
        return personaRepository.findByEmail(mail);
    }
}