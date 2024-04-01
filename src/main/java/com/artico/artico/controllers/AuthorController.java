package com.artico.artico.controllers;

import com.artico.artico.models.LocalUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {
    @GetMapping("/author-profile")
    public String showAuthorProfile() {
        return "author-profile";

    }

    @GetMapping("/author")
    public LocalUser getLoginUserProfile(@AuthenticationPrincipal LocalUser user) {
        return user;
    }

}
