package com.example.webshop.util.validate.auth;

import com.example.webshop.annotation.validation.auth.ValidToken;
import com.example.webshop.service.AuthService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class TokenValidator implements ConstraintValidator<ValidToken, String> {
    private final AuthService authService;

    @Override
    public void initialize(ValidToken validToken){
    }

    @Override
    public boolean isValid(String token, ConstraintValidatorContext ctx) {
        return authService.validateToken(token) != null;
    }
}
