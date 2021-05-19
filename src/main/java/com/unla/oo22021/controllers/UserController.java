package com.unla.oo22021.controllers;

import com.unla.oo22021.helpers.ViewRouteHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(name="error",required=false) String error,
                        @RequestParam(name="logout", required=false) String logout) {

        model.addAttribute("error", error);
        model.addAttribute("logout", logout);

        return ViewRouteHelper.USER_LOGIN;
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return ViewRouteHelper.USER_LOGOUT;
    }

    @GetMapping("/loginsuccess")
    public String loginCheck() {
        return "redirect:/index";
    }
}