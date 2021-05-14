package com.unla.oo22021.controllers;

import com.unla.oo22021.helpers.ViewRouteHelper;
import com.unla.oo22021.services.implementation.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    @Qualifier("personaService")
    private PersonaService personaService;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        mAV.addObject("username", user.getUsername());
        mAV.addObject("personas", personaService.findAllAndUserWithRoles());

        return mAV;
    }

    @GetMapping("/")
    public RedirectView redirectToHomeIndex() {
        return new RedirectView(ViewRouteHelper.ROUTE);
    }
}