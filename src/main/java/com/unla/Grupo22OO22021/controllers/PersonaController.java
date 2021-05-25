package com.unla.Grupo22OO22021.controllers;

import com.unla.Grupo22OO22021.converters.PersonaConverter;
import com.unla.Grupo22OO22021.entities.Persona;
import com.unla.Grupo22OO22021.entities.UserRole;
import com.unla.Grupo22OO22021.helpers.ViewRouteHelper;
import com.unla.Grupo22OO22021.models.PersonaModel;
import com.unla.Grupo22OO22021.models.UserRoleModel;
import com.unla.Grupo22OO22021.servicies.implementations.PersonaService;
import com.unla.Grupo22OO22021.servicies.implementations.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    @Qualifier("personaService")
    private PersonaService personaService;

    @Autowired
    @Qualifier("userRoleService")
    private UserRoleService userRoleService;

    @Autowired
    @Qualifier("personaConverter")
    private PersonaConverter personaConverter;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/agregar")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PERSONA_ADD);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<UserRole> roles = userRoleService.getAll();

        PersonaModel persona = new PersonaModel();
        com.unla.Grupo22OO22021.entities.User userNuevo = new com.unla.Grupo22OO22021.entities.User();
        UserRole userRole = new UserRole();
        Set<UserRole> userRoles = new HashSet<>();

        userRoles.add(userRole);
        userNuevo.setUserRoles(userRoles);
        persona.setUser(userNuevo);

        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("persona", persona);
        modelAndView.addObject("roles", roles);

        return modelAndView;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public RedirectView create(@ModelAttribute("persona")PersonaModel personaModel) {
        String password = personaModel.getUser().getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = userRoleService.findByRole(personaModel.getUserRole());

        userRoles.add(userRole);
        personaModel.getUser().setEnabled(true);
        personaModel.getUser().setPassword(encoder.encode(password));
        personaModel.getUser().setUserRoles(userRoles);
        personaService.insertOrUpdate(personaModel);

        return new RedirectView(ViewRouteHelper.ROUTE);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/editar/{dni}")
    public ModelAndView edit(@PathVariable("dni") long dni) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PERSONA_ADD);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PersonaModel personaModel = new PersonaModel();
        List<UserRole> roles = userRoleService.getAll();

        try {
            List<Persona> personas = personaService.findAllAndUserWithRoles();
            personas.removeIf(persona -> persona.getDni() != dni);
            personaModel = personaConverter.entityToModel(personas.get(0));
        } catch (Exception e) {
            System.out.println(e);
        }

        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("persona", personaModel);
        modelAndView.addObject("roles", roles);

        return modelAndView;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/eliminar/{id}")
    public RedirectView remove(@PathVariable("id") int id) {
        //personaService.remove(id);

        try {
            List<Persona> personas = personaService.findAllAndUserWithRoles();
            personas.removeIf(persona -> persona.getId() != id);
            Persona persona = personas.get(0);
            persona.getUser().setEnabled(false);

            personaService.insertOrUpdate(personaConverter.entityToModel(persona));
        } catch (Exception e) {
            System.out.println(e);
        }

        return new RedirectView(ViewRouteHelper.ROUTE);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("")
    public ModelAndView listaPersonas() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PERSONA_INDEX);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Persona> personas = personaService.findAllAndUserWithRoles();
        personas.removeIf(persona -> !persona.getUser().isEnabled());

        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("personas", personas);

        return modelAndView;
    }
}
