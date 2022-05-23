package com.example.webshop.util.validate.auth;

import com.example.webshop.annotation.validation.auth.RequiredRole;
import com.example.webshop.entity.Auth;
import com.example.webshop.entity.User;
import com.example.webshop.model.enums.Role;
import com.example.webshop.model.request.RequestAuthLogin;
import com.example.webshop.service.AuthService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

@RequiredArgsConstructor
public class RequiredRoleValidator implements ConstraintValidator<RequiredRole, String> {
    private final AuthService authService;
    private Role role;

    @Override
    public void initialize(RequiredRole requiredRole) {
        this.role = requiredRole.role();
    }

    @Override
    public boolean isValid(String token, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        final User user = authService.validateToken(token).getUser();

        if(user == null){
            addConstraintViolation(context, "access-token", "This token is invalid.");
            return false;
        }

        if(Objects.equals(user.getRole(), role.getValue())){return true;}

        addConstraintViolation(context, "access-token", "You are not a(n) " + role.getValue() + ".");
        return false;
    }
    private void addConstraintViolation(ConstraintValidatorContext context, String property, String message){
        context
                .buildConstraintViolationWithTemplate(message)
                .addPropertyNode(property)
                .addConstraintViolation();
    }
}
