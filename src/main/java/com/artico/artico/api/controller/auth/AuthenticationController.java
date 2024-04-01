package com.artico.artico.api.controller.auth;

import com.artico.artico.api.exeption.UserAlreadyExistsException;
import com.artico.artico.api.model.LoginBody;
import com.artico.artico.api.model.LoginResponse;
import com.artico.artico.api.model.RegistrationBody;
import com.artico.artico.models.LocalUser;
import com.artico.artico.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/register")
    public String registerUser( RegistrationBody registrationBody, Model model){
        try {
            userService.registerUser(registrationBody);
            System.out.println(registrationBody.getFirstName() + " " + registrationBody.getLastName() + " register");
            return "redirect:/";
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/create";
        }
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody){
        String jwt = userService.loginUser(loginBody);
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }else {
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            System.out.println("user logged !!!");
            return ResponseEntity.ok(response);

        }

    }
    @GetMapping("/author")
    public LocalUser getLoginUserProfile(@AuthenticationPrincipal LocalUser user){
        return user;
    }
}
