package com.example.webshop.util.validate.auth;

import com.example.webshop.annotation.validation.auth.EmailUnique;
import com.example.webshop.service.AuthService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class EmailValidator implements ConstraintValidator<EmailUnique, String> {
    private final AuthService authService;

    @Override
    public void initialize(EmailUnique emailUnique){
    }

    @Override
    public boolean isValid(String emailField, ConstraintValidatorContext ctx) {
        return !authService.exists(emailField);
    }
}
