package com.unla.oo22021.services;

import com.unla.oo22021.entities.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userRoleService")
public interface IUserRoleService {
    List<UserRole> listAll();
    List<UserRole> listDistinctByRole();
}
