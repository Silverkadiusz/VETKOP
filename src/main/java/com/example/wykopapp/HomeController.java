package com.example.wykopapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {

    @GetMapping("")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String register() {
        return "register-form";
    }

    /*
    @GetMapping("/toLogin")
    public String signIn() {
        return "signin";
    }

     */

    @GetMapping("/secure")
    public String secure() {
        return "secure";
    }

}
