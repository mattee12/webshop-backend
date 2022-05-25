package com.example.webshop.util.validate.string;

import com.example.webshop.annotation.validation.auth.StringLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringLengthValidator implements ConstraintValidator<StringLength, String> {
    private int min;
    private int max;
    private int length;

    public void initialize(StringLength stringLength){
        this.min = stringLength.min();
        this.max = stringLength.max();
        this.length = stringLength.length();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return !isNotSet(this.min) && !isNotSet(this.length);
        }
        final int stringLength = value.length();
        final boolean result = isMin(stringLength) && isMax(stringLength) && isLength(stringLength);
        return result;
    }

    private boolean isMin(int length){
        return isNotSet(this.min) || length >= this.min;
    }

    private boolean isMax(int length){
        return isNotSet(this.max) || length <= this.max;
    }

    private boolean isLength(int length){
        return isNotSet(this.length) || length == this.length;
    }

    private boolean isNotSet(int value){
        return value < 0;
    }
}
