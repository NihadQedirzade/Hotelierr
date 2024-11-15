package com.example.hoteliermvc.controlles;


import com.example.hoteliermvc.dtos.UserDtos.UserRegisterDto;
import com.example.hoteliermvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/auth/login";
    }


    @GetMapping("/register")
    public String register(){
        return "/auth/register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userRegisterDto){
        userService.registerUser(userRegisterDto);
        return "redirect:/login";
    }
    @GetMapping("auth/confrim")
    public String confirm(String email, String token)
    {
        boolean res = userService.confirmEmail(email, token);
        return "redirect:/login";
    }
}

