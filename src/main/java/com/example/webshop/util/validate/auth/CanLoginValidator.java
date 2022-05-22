package com.example.webshop.util.validate.auth;

import com.example.webshop.annotation.validation.auth.CanLogin;
import com.example.webshop.entity.Auth;
import com.example.webshop.model.request.RequestAuthLogin;
import com.example.webshop.service.AuthService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class CanLoginValidator implements ConstraintValidator<CanLogin, RequestAuthLogin> {
    private final AuthService authService;

    @Override
    public void initialize(CanLogin canLogin) {
    }

    @Override
    public boolean isValid(RequestAuthLogin request, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        final String email = request.getEmail();
        final String password = request.getPassword();
        final String token = request.getToken();

        if(token != null && !token.isBlank()){
            Auth result = authService.validateToken(token);
            if(result != null){
                request.setEmail(result.getEmail());
                return true;
            }
            addConstraintViolation(context, "token", "Invalid token.");
            return false;
        }

        boolean attemptLogin = true;
        if(email == null || email.isBlank()) {
            addConstraintViolation(context, "email", "Email address is mandatory.");
            attemptLogin = false;
        }
        if(password == null || password.isBlank()){
            addConstraintViolation(context, "password", "Password must not be empty.");
            attemptLogin = false;
        }
        if(attemptLogin){
            if(authService.login(request.toEntity()) != null){return true;}
            addConstraintViolation(context, "password", "Invalid credentials.");
        }
        return false;
    }
    private void addConstraintViolation(ConstraintValidatorContext context, String property, String message){
        context
                .buildConstraintViolationWithTemplate(message)
                .addPropertyNode(property)
                .addConstraintViolation();
    }
}
