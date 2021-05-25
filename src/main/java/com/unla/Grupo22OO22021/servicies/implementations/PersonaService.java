package com.unla.Grupo22OO22021.servicies.implementations;

import com.unla.Grupo22OO22021.converters.PersonaConverter;
import com.unla.Grupo22OO22021.entities.Persona;
import com.unla.Grupo22OO22021.models.PersonaModel;
import com.unla.Grupo22OO22021.repositories.IPersonaRepository;
import com.unla.Grupo22OO22021.servicies.IPersonaService;
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
    public PersonaModel insertOrUpdate(PersonaModel personaModel) {
        Persona persona = personaRepository.save(personaConverter.modelToEntity(personaModel));
        return personaConverter.entityToModel(persona);
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
    public List<Persona> findAllAndUserWithRoles() {
        return personaRepository.findAllAndUSerWithRoles();
    }

    @Override
    public PersonaModel findPersonaByDniWithRoles(long dni) {
        return personaRepository.findPersonaByDniWithRoles(dni);
    }
}
