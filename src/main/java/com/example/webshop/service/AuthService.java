package com.example.webshop.service;

import com.example.webshop.entity.Auth;
import com.example.webshop.entity.User;

public interface AuthService {
    Auth register(Auth auth);

    Auth login(Auth auth);

    Auth validateToken(String token);

    Auth getAuthFromEmail(String email);

    boolean exists(String email);
}
