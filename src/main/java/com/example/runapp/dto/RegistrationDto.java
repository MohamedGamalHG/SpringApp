package com.example.runapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private Long id;
    @NotEmpty(message = "name should not be empty")
    private String name;
    @NotEmpty(message = "email should not be empty")
    private String email;
    @NotEmpty(message = "password should not be empty")
    private String password;
}
