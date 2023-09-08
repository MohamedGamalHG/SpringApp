package com.example.runapp.controllers;

import com.example.runapp.Service.UserService;
import com.example.runapp.dto.RegistrationDto;
import com.example.runapp.dto.UserDTo;
import com.example.runapp.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/auth")
public class AuthController {
    private UserService userService;
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String Login() {
        return "auth/login";
    }
  /*  @PostMapping("/save/login")
    public String Login() {
        return "redirect:/auth/register";
    }*/
    @GetMapping("/register")
    public String Register(Model model) {
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "auth/register";
    }
    @PostMapping("/save/register")
    public String save(@ModelAttribute RegistrationDto registrationDto, Model model){
        userService.save(registrationDto);
        return "redirect:/auth/register";
    }
}
