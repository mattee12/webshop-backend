package com.example.webshop.model.request;

import com.example.webshop.annotation.validation.auth.EmailUnique;
import com.example.webshop.entity.Auth;
import com.example.webshop.util.convert.ConvertAuth;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class RequestAuthRegister {
    @NotBlank(message = "Email address is mandatory.")
    @EmailUnique
    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotBlank(message = "Please provide a password.")
    private String password;

    public Auth toEntity(){
        return ConvertAuth.convertRequestRegisterToEntity(this);
    }
}

