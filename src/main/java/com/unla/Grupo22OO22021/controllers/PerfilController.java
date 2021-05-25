package com.unla.Grupo22OO22021.controllers;

import com.unla.Grupo22OO22021.converters.UserRoleConverter;
import com.unla.Grupo22OO22021.entities.Persona;
import com.unla.Grupo22OO22021.entities.UserRole;
import com.unla.Grupo22OO22021.helpers.ViewRouteHelper;
import com.unla.Grupo22OO22021.models.UserRoleModel;
import com.unla.Grupo22OO22021.servicies.implementations.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    @Qualifier("userRoleService")
    private UserRoleService userRoleService;

    @Autowired
    @Qualifier("userRoleConverter")
    private UserRoleConverter userRoleConverter;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/agregar")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PERFIL_ADD);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserRoleModel userRoleModel = new UserRoleModel();

        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("userRole", userRoleModel);

        return modelAndView;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public RedirectView create(@ModelAttribute("userRole") UserRoleModel userRoleModel) {
        UserRole userRole = userRoleService.findByRole(userRoleModel.getRole());

        if (userRole == null) {
            userRoleService.insertOrUpdate(userRoleModel);
        }

        return new RedirectView(ViewRouteHelper.ROUTE);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/editar/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PERFIL_ADD);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserRoleModel userRoleModel = new UserRoleModel();

        // ID = 1 ADMIN , ID = 2 AUDITOR
        if (id != 1 && id != 2) {
            try {
                userRoleModel = userRoleConverter.entityToModel(userRoleService.findById(id));
            } catch (Exception e) {

            }
        }

        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("userRole", userRoleModel);

        return modelAndView;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/eliminar/{id}")
    public RedirectView remove(@PathVariable("id") int id) {
        // ID = 1 ADMIN , ID = 2 AUDITOR
        if (id != 1 && id != 2) {
            userRoleService.remove(id);
        }

        return new RedirectView(ViewRouteHelper.ROUTE);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("")
    public ModelAndView listaPersonas() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PERFIL_INDEX);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<UserRole> roles = userRoleService.getAll();

        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("roles", roles);

        return modelAndView;
    }
}
