package com.example.webshop.annotation.validation.auth;

import com.example.webshop.util.validate.auth.EmailValidator;
import com.example.webshop.util.validate.auth.TokenValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TokenValidator.class)
@Target( {ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidToken {
    String message() default "This token is not valid.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
