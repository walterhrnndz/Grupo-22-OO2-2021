package com.unla.oo22021.services.implementation;

import com.unla.oo22021.converters.UserConverter;
import com.unla.oo22021.entities.UserRole;
import com.unla.oo22021.models.UserModel;
import com.unla.oo22021.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private IUserRepository userRepository;

    @Autowired
    @Qualifier("userConverter")
    private UserConverter userConverter;

    public List<com.unla.oo22021.entities.User> listAll() {
        return userRepository.findAll();
    }

    public UserModel insertOrUpdate(UserModel userModel) {
        com.unla.oo22021.entities.User user = userRepository.save(userConverter.modelToEntity(userModel));
        return userConverter.entityToModel(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.unla.oo22021.entities.User user = userRepository.findByUsernameAndFetchRolesEagerly(username);

        return buildUser(user, buildGrantedAuthorities(user.getUserRoles()));
    }

    private User buildUser(com.unla.oo22021.entities.User user, List<GrantedAuthority> grantedAuthorities) {
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true,
                true, true, grantedAuthorities);
    }

    private List<GrantedAuthority> buildGrantedAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (UserRole userRole: userRoles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<>(grantedAuthorities);
    }
}