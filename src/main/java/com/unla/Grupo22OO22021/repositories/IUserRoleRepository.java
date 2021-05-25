package com.unla.Grupo22OO22021.repositories;

import com.unla.Grupo22OO22021.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userRoleRepository")
public interface IUserRoleRepository extends JpaRepository<UserRole, Serializable> {

    @Query(value = "SELECT * FROM user_role WHERE role LIKE :role", nativeQuery = true)
    UserRole findByRole(String role);

    UserRole findById(int id);
}
