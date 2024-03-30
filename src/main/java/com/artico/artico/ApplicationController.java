package com.artico.artico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String goHome() {
        return "index.html";
    }

    @GetMapping("/register")
    public String register(){
        return "register.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }
    @GetMapping("/author-profile")
    public String showAuthorProfile(){
        return "author-profile.html";

    }

    @GetMapping("/404")
    public String show404(){
        return "404.html";
    }




}
