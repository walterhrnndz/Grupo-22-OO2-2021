package com.unla.oo22021.services.implementation;

import com.unla.oo22021.entities.UserRole;
import com.unla.oo22021.repositories.IUserRoleRepository;
import com.unla.oo22021.services.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userRoleService")
public class UserRoleService implements IUserRoleService {

    @Autowired
    @Qualifier("userRoleRepository")
    private IUserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> listAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public List<UserRole> listDistinctByRole() {
        return userRoleRepository.findAllDistinctByRole();
    }
}
