package com.unla.oo22021.controllers;

import com.unla.oo22021.converters.PersonaConverter;
import com.unla.oo22021.entities.Persona;
import com.unla.oo22021.helpers.ViewRouteHelper;
import com.unla.oo22021.models.PersonaModel;
import com.unla.oo22021.models.UserModel;
import com.unla.oo22021.services.IPersonaService;
import com.unla.oo22021.services.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    @Qualifier("personaService")
    private IPersonaService personaService;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("personaConverter")
    private PersonaConverter personaConverter;

    @GetMapping("")
    public RedirectView index() {
        return new RedirectView(ViewRouteHelper.ROUTE);
    }

    @GetMapping("/agregar")
    public ModelAndView usuario() {
        ModelAndView mAV = new ModelAndView((ViewRouteHelper.PERSONA_ADD));
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        PersonaModel persona = new PersonaModel();
        UserModel userModel = new UserModel();

        persona.setUserModel(userModel);

        mAV.addObject("username", user.getUsername());
        mAV.addObject("persona", persona);

        return mAV;
    }

    @PostMapping("")
    public RedirectView create(@ModelAttribute("persona") PersonaModel personaModel) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserModel userModel = personaModel.getUserModel();

        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        personaModel.setUserModel(userModel);
        personaService.insertOrUpdate(personaModel);

        return new RedirectView(ViewRouteHelper.ROUTE);
    }

    @GetMapping("/editar/{nroDNI}")
    public ModelAndView edit(@PathVariable("nroDNI") String nroDNI) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PERSONA_ADD);
        Persona persona = personaService.findByNroDni(nroDNI);

        modelAndView.addObject("persona", persona);

        return modelAndView;
    }

    @GetMapping("/eliminar/{id}")
    public RedirectView remove(@PathVariable("id") int id) {
        personaService.remove(id);
        return new RedirectView(ViewRouteHelper.PERSONA_ROOT);
    }
}