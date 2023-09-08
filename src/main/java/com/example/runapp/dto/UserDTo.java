package com.example.runapp.dto;

import com.example.runapp.models.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTo {

    private Long id;
    @NotEmpty(message = "name should not be empty")
    private String name;
    @NotEmpty(message = "email should not be empty")
    private String email;
    @NotEmpty(message = "password should not be empty")
    private String password;

    private List<Role> roles;
}
