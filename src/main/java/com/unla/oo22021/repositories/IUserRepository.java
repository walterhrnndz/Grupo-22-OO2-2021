package com.unla.oo22021.repositories;

import com.unla.oo22021.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable> {
    @Query("SELECT u FROM User u JOIN FETCH u.userRoles WHERE u.username = (:username)")
    User findByUsernameAndFetchRolesEagerly(@Param("username") String username);

    @Query(value = "select * from persona inner join tpoo2.user on persona.user_id = tpoo2.user.id inner join user_role on tpoo2.user.id = user_role.user_id;", nativeQuery = true)
    List<User> findAll();
}