package com.artico.artico.model;

import com.artico.artico.models.UserRole;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationBody {
    @NotNull
    @NotBlank
    @Size(min = 4, max = 255)
    private String username;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    @Size(min = 4, max = 32)
    private String password;

    @Email
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    private UserRole role;
}
