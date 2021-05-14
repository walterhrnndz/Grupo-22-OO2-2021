package com.unla.oo22021.repositories;

import com.unla.oo22021.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("personaRepository")
public interface IPersonaRepository extends JpaRepository<Persona, Serializable> {

    Persona findByEmail(String email);

    @Query(value = "select * from persona join tpoo2.user on persona.id = tpoo2.user.persona_id join user_role on user_role.user_id = tpoo2.user.id;", nativeQuery = true)
    List<Persona> findAllAndUserWithRoles();
}