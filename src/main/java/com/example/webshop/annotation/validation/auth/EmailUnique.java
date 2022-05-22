package com.example.webshop.annotation.validation.auth;

import com.example.webshop.util.validate.auth.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnique {
    String message() default "This email address is already in use.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
