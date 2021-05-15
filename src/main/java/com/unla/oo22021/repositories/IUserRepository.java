package com.unla.oo22021.repositories;

import com.unla.oo22021.entities.User;
import com.unla.oo22021.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable> {
    @Query("SELECT u FROM User u JOIN FETCH u.userRoles WHERE u.username = (:username)")
    User findByUsernameAndFetchRolesEagerly(@Param("username") String username);
}