package com.unla.Grupo22OO22021.repositories;

import com.unla.Grupo22OO22021.entities.Persona;
import com.unla.Grupo22OO22021.models.PersonaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("personaRepository")
public interface IPersonaRepository extends JpaRepository<Persona, Serializable> {

    Persona findByNombre(String nombre);
    Persona findByDni(long dni);

    @Query(value = "SELECT * FROM persona INNER JOIN user on user_id = user.id INNER JOIN user_to_role on user_to_role.user_id = user.id INNER JOIN user_role on user_role.id = user_to_role.role_id", nativeQuery = true)
    List<Persona> findAllAndUSerWithRoles();

    @Query(value = "SELECT * FROM persona INNER JOIN user on user_id = user.id INNER JOIN user_to_role on user_to_role.user_id = user.id INNER JOIN user_role on user_role.id = user_to_role.role_id WHERE persona.dni = :dni", nativeQuery = true)
    PersonaModel findPersonaByDniWithRoles(long dni);
}
