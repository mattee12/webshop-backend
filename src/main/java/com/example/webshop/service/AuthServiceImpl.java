package com.example.webshop.service;

import com.example.webshop.entity.Auth;
import com.example.webshop.entity.Cart;
import com.example.webshop.entity.User;
import com.example.webshop.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final AuthRepository authRepository;

    @Override
    public Auth register(Auth auth){
        User user = new User();
        Cart cart = new Cart();
        user.setEmail(auth.getEmail());
        user.setCart(cart);
        auth.setUser(user);

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        auth.setSalt(Base64Utils.encodeToString(salt));

        byte[] token = new byte[64];
        random.nextBytes(token);
        auth.setToken(Base64Utils.encodeToUrlSafeString(token));

        auth.setPassword(hashString(auth.getPassword(), salt));
        return filterSensitive(authRepository.save(auth));
    }

    @Override
    public Auth login(Auth auth){
        if(auth.getPassword() != null){
            Auth reference = authRepository.findById(auth.getEmail()).orElse(null);
            if(reference == null){return null;}
            return hashString(auth.getPassword(), Base64Utils.decodeFromString(reference.getSalt()))
                    .equals(reference.getPassword())?
                    filterSensitive(reference): null;
        }
        if(auth.getToken() != null){
            return filterSensitive(validateToken(auth.getToken()));
        }
        return null;
    }

    @Override
    public Auth getAuthFromEmail(String email){
        try{
            return filterSensitive(Objects.requireNonNull(authRepository.findById(email).orElse(null)));
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Auth validateToken(String token){
        return authRepository.findByToken(token).orElse(null);
    }

    @Override
    public boolean exists(String email){
        return getAuthFromEmail(email) != null;
    }

    private Auth filterSensitive(Auth source){
        source.setPassword(null);
        source.setSalt(null);
        return source;
    }
    private String hashString(String raw, byte[] salt){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] hashedPassword = md.digest(raw.getBytes(StandardCharsets.UTF_8));
            return Base64Utils.encodeToString(hashedPassword);
        } catch(NoSuchAlgorithmException exception) {
            System.out.println(exception.getMessage());
        }
        return "";
    }
}
