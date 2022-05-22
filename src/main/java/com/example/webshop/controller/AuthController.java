package com.example.webshop.controller;

import com.example.webshop.entity.Auth;
import com.example.webshop.model.request.RequestAuthLogin;
import com.example.webshop.model.request.RequestAuthRegister;
import com.example.webshop.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public Auth login(@Validated @RequestBody RequestAuthLogin request){
        return authService.getAuthFromEmail(request.getEmail());
    }

    @PostMapping("/register")
    public Auth register(@Validated @RequestBody RequestAuthRegister request){
        return authService.register(request.toEntity());
    }
}
