package com.example.wykopapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {


   /* @GetMapping("/register")
    public String register() {
        return "register-form";
    }

    /*
    @GetMapping("/toLogin")
    public String signIn() {
        return "signin";
    }

     */

    @GetMapping("")
    public String homepage() {
        return "home";
    }

    @GetMapping("/secure")
    public String secure() {
        return "secure";
    }

}
