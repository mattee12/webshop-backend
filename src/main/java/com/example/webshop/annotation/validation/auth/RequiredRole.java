package com.example.webshop.annotation.validation.auth;

import com.example.webshop.model.enums.Role;
import com.example.webshop.util.validate.auth.RequiredRoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RequiredRoleValidator.class)
@Target({ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredRole {
    String message() default "You don't have the permission to do this.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Role role() default Role.USER;
}
