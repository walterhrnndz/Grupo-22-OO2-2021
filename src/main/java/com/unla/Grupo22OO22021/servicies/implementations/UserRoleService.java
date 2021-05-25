package com.unla.Grupo22OO22021.servicies.implementations;

import com.unla.Grupo22OO22021.converters.UserRoleConverter;
import com.unla.Grupo22OO22021.entities.UserRole;
import com.unla.Grupo22OO22021.models.UserRoleModel;
import com.unla.Grupo22OO22021.repositories.IUserRoleRepository;
import com.unla.Grupo22OO22021.servicies.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userRoleService")
public class UserRoleService implements IUserRoleService {

    @Autowired
    @Qualifier("userRoleRepository")
    private IUserRoleRepository userRoleRepository;

    @Autowired
    @Qualifier("userRoleConverter")
    private UserRoleConverter userRoleConverter;

    @Override
    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRoleModel insertOrUpdate(UserRoleModel userRoleModel) {
        UserRole userRole = userRoleRepository.save(userRoleConverter.modelToEntity(userRoleModel));
        return userRoleConverter.entityToModel(userRole);
    }

    @Override
    public boolean remove(int id) {
        try {
            userRoleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public UserRole findByRole(String role) {
        return userRoleRepository.findByRole(role);
    }

    @Override
    public UserRole findById(int id) {
        return userRoleRepository.findById(id);
    }
}
