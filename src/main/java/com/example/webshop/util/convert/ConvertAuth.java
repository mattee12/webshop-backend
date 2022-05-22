package com.example.webshop.util.convert;

import com.example.webshop.entity.Auth;
import com.example.webshop.model.request.RequestAuthLogin;
import com.example.webshop.model.request.RequestAuthRegister;

public class ConvertAuth {
    private ConvertAuth(){
        throw new UnsupportedOperationException();
    }

    public static Auth convertRequestRegisterToEntity(RequestAuthRegister source){
        Auth auth = new Auth();
        auth.setEmail(source.getEmail());
        auth.setPassword(source.getPassword());
        return auth;
    }

    public static Auth convertRequestLoginToEntity(RequestAuthLogin source){
        Auth auth = new Auth();
        auth.setEmail(source.getEmail());
        auth.setToken(source.getToken());
        auth.setPassword(source.getPassword());
        return auth;
    }
}
