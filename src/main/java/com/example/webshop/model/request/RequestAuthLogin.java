package com.example.webshop.model.request;

import com.example.webshop.annotation.validation.auth.CanLogin;
import com.example.webshop.entity.Auth;
import com.example.webshop.util.convert.ConvertAuth;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@CanLogin
public class RequestAuthLogin {
    private String email;
    private String password;
    private String token;

    public Auth toEntity(){
        return ConvertAuth.convertRequestLoginToEntity(this);
    }
}

