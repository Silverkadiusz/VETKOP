package com.example.wykopapp.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logowanie")
    public String loginForm(@RequestParam(required = false) String error,
                            Model model, User user) {
        boolean showErrorMessage = false;

        if (error != null) {
            showErrorMessage = true;

        }

        model.addAttribute("showErrorMessage", showErrorMessage);

        return "signin";
    }

    @PostMapping("/registerPost")
    public String register(User user) {
        String username = user.getUsername();
        String rawPassword = user.getPassword();
        userService.registerUser(username, rawPassword);
        return "signin";
    }
}
