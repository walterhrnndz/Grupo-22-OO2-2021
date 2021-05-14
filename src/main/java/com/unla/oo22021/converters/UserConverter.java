package com.unla.oo22021.converters;

import com.unla.oo22021.entities.User;
import com.unla.oo22021.models.UserModel;
import org.springframework.stereotype.Component;

@Component("userConverter")
public class UserConverter {
    public UserModel entityToModel(User user) {
        return new UserModel(user.getId(),
                user.getUsername(),
                user.getPassword());
    }

    public User modelToEntity(UserModel userModel) {
        return new User(userModel.getId(),
                userModel.getUsername(),
                userModel.getPassword());
    }
}