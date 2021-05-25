package com.unla.Grupo22OO22021.converters;

import com.unla.Grupo22OO22021.entities.Persona;
import com.unla.Grupo22OO22021.models.PersonaModel;
import org.springframework.stereotype.Component;

@Component("personaConverter")
public class PersonaConverter {

    public PersonaModel entityToModel(Persona persona) {
        return new PersonaModel(persona.getId(),
                persona.getNombre(),
                persona.getApellido(),
                persona.getTipoDni(),
                persona.getDni(),
                persona.getEmail(),
                persona.getUser());
    }

    public Persona modelToEntity(PersonaModel personaModel) {
        return new Persona(personaModel.getId(),
                personaModel.getNombre(),
                personaModel.getApellido(),
                personaModel.getTipoDni(),
                personaModel.getDni(),
                personaModel.getEmail(),
                personaModel.getUser());
    }
}
