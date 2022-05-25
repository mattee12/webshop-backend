package com.example.webshop.annotation.validation.auth;

import com.example.webshop.util.validate.string.StringLengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringLengthValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StringLength {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int min() default -1;
    int max() default -1;
    int length() default -1;

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        StringLength[] value();
    };
}
