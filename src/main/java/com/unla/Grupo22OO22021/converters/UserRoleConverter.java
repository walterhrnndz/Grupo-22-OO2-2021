package com.unla.Grupo22OO22021.converters;

import com.unla.Grupo22OO22021.entities.UserRole;
import com.unla.Grupo22OO22021.models.UserRoleModel;
import org.springframework.stereotype.Component;

@Component("userRoleConverter")
public class UserRoleConverter {

    public UserRoleModel entityToModel(UserRole userRole) {
        return new UserRoleModel(userRole.getId(), userRole.getRole());
    }

    public UserRole modelToEntity(UserRoleModel userRoleModel) {
        return new UserRole(userRoleModel.getId(), userRoleModel.getRole());
    }
}
