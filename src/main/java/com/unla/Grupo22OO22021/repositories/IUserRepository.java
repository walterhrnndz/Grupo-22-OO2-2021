package com.unla.Grupo22OO22021.repositories;

import com.unla.Grupo22OO22021.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable> {

    @Query(value = "SELECT * FROM user INNER JOIN user_to_role on user.id = user_id INNER JOIN user_role on role_id = user_role.id WHERE username LIKE :username", nativeQuery = true)
    User findByUsernameAndFetchUserRoles(String username);
}