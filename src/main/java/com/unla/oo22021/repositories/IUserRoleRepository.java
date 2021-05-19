package com.unla.oo22021.repositories;

import com.unla.oo22021.entities.UserRole;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("userRoleRepository")
public interface IUserRoleRepository extends JpaRepository<UserRole, Serializable> {

    @Query(value = "SELECT * FROM tpoo2.user_role group by role;", nativeQuery = true)
    List<UserRole> findAllDistinctByRole();
}
