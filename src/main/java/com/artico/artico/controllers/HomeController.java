package com.artico.artico.controllers;

import com.artico.artico.api.model.RegistrationBody;
import com.artico.artico.models.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("welcome", "Welcome maina");
        return "index";
    }

    @GetMapping("/create")
    public String createPage(Model model, @RequestParam(defaultValue = "client") UserRole type) {
        // client, creator
        model.addAttribute("type", type);
        model.addAttribute("registrationBody", new RegistrationBody());
        return "create";
    }
}
