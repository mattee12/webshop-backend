package com.example.webshop.annotation.validation.auth;

import com.example.webshop.util.validate.auth.CanLoginValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CanLoginValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CanLogin {
    String message() default "Invalid credentials.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
