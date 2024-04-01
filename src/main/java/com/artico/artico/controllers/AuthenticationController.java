package com.artico.artico.controllers;

import com.artico.artico.exeption.UserAlreadyExistsException;
import com.artico.artico.model.LoginBody;
import com.artico.artico.model.LoginResponse;
import com.artico.artico.model.RegistrationBody;
import com.artico.artico.models.LocalUser;
import com.artico.artico.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(RegistrationBody registrationBody, Model model) {
        try {
            userService.registerUser(registrationBody);
            System.out.println(registrationBody.getFirstName() + " " + registrationBody.getLastName() + " register");
            return "redirect:/";
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/create";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody) {
        String jwt = userService.loginUser(loginBody);
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        } else {
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            System.out.println("user logged !!!");
            return ResponseEntity.ok(response);

        }

    }

    @GetMapping("/author-profile")
    public String showAuthorProfile() {
        return "author-profile";

    }

    @GetMapping("/author")
    public LocalUser getLoginUserProfile(@AuthenticationPrincipal LocalUser user) {
        return user;
    }
}
