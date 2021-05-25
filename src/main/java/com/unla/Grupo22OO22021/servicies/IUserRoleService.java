package com.unla.Grupo22OO22021.servicies;

import com.unla.Grupo22OO22021.entities.UserRole;
import com.unla.Grupo22OO22021.models.UserRoleModel;

import java.util.List;
import java.util.Optional;

public interface IUserRoleService {

    List<UserRole> getAll();
    UserRoleModel insertOrUpdate(UserRoleModel userRoleModel);
    boolean remove(int id);

    UserRole findByRole(String role);

    UserRole findById(int id);
}
