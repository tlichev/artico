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

    @GetMapping("/404")
    public String show404() {
        return "404";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
