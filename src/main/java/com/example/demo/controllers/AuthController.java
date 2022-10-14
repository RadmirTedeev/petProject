package com.example.demo.controllers;

import com.example.demo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping("/registration")
    public String showRegistrationPage(@ModelAttribute("registration_form") User user) {
        return "registration-form";
    }

    @RequestMapping(value = "/process_registration", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("registration_form") @Validated User user) {
        return "registration-form";
    }
}
