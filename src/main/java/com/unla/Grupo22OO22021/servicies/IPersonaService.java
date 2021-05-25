package com.unla.Grupo22OO22021.servicies;

import com.unla.Grupo22OO22021.entities.Persona;
import com.unla.Grupo22OO22021.models.PersonaModel;

import java.util.List;

public interface IPersonaService {

    List<Persona> getAll();

    PersonaModel insertOrUpdate(PersonaModel personaModel);

    boolean remove(int id);

    List<Persona> findAllAndUserWithRoles();

    PersonaModel findPersonaByDniWithRoles(long dni);
}
