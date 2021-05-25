package com.unla.Grupo22OO22021.controllers;

import com.unla.Grupo22OO22021.entities.Persona;
import com.unla.Grupo22OO22021.entities.UserRole;
import com.unla.Grupo22OO22021.helpers.ViewRouteHelper;
import com.unla.Grupo22OO22021.models.UserRoleModel;
import com.unla.Grupo22OO22021.servicies.implementations.PersonaService;
import com.unla.Grupo22OO22021.servicies.implementations.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    @Qualifier("personaService")
    private PersonaService personaService;

    @Autowired
    @Qualifier("userRoleService")
    private UserRoleService userRoleService;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Persona> personas = personaService.findAllAndUserWithRoles();
        personas.removeIf(persona -> !persona.getUser().isEnabled());

        List<UserRole> roles = userRoleService.getAll();

        mAV.addObject("username", user.getUsername());
        mAV.addObject("personas", personas);
        mAV.addObject("roles", roles);

        return mAV;
    }

    @GetMapping("/")
    public RedirectView redirectToHomeIndex() {
        return new RedirectView(ViewRouteHelper.ROUTE);
    }
}