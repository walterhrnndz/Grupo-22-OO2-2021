package com.unla.oo22021.converters;

import com.unla.oo22021.entities.Persona;
import com.unla.oo22021.models.PersonaModel;
import org.springframework.stereotype.Component;

@Component("personaConverter")
public class PersonaConverter {

    public PersonaModel entityToModel(Persona persona) {
        return new PersonaModel(persona.getId(),
                persona.getNombre(),
                persona.getApellido(),
                persona.getTipoDni(),
                persona.getNroDni(),
                persona.getEmail());
    }

    public Persona modelToEntity(PersonaModel personaModel) {
        return new Persona(personaModel.getId(),
                personaModel.getNombre(),
                personaModel.getApellido(),
                personaModel.getTipoDni(),
                personaModel.getNroDni(),
                personaModel.getEmail());
    }
}
