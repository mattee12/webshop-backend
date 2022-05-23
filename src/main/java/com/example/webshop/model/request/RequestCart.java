package com.example.webshop.model.request;

import com.example.webshop.annotation.validation.auth.CanLogin;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@CanLogin
@Getter
public class RequestCart {
    @NotBlank(message = "Token is mandatory.")
    private String token;
}
