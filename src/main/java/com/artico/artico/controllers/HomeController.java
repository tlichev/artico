package com.artico.artico.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("welcome", "Welcome maina");
        return "index";
    }

//    todo remove
//    @GetMapping("/create")
//    public String createPage(Model model, @RequestParam(defaultValue = "client") UserRole type) {
//        // client, creator
//        model.addAttribute("type", type);
//        model.addAttribute("registrationBody", new RegistrationBody());
//        return "create";
//    }

    @GetMapping("/404")
    public String show404() {
        return "404";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
