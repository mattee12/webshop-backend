package com.example.webshop.controller;

import com.example.webshop.annotation.validation.auth.ValidToken;
import com.example.webshop.entity.Auth;
import com.example.webshop.entity.Cart;
import com.example.webshop.entity.ShopItem;
import com.example.webshop.entity.User;
import com.example.webshop.model.dto.CartDto;
import com.example.webshop.service.AuthService;
import com.example.webshop.service.CartService;
import com.example.webshop.util.convert.ConvertCart;
import com.example.webshop.util.convert.ConvertShopItem;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@Validated
@CrossOrigin(originPatterns = "http://localhost:[*]", allowCredentials = "true")
public class CartController {
    private final AuthService authService;
    private final CartService cartService;

    @GetMapping("/")
    public Cart getCart(@CookieValue("access-token") @NotBlank(message = "Token is mandatory.") @ValidToken String token){
        final Auth resultAuth = authService.validateToken(token);
        if(resultAuth == null){return null;}
        return resultAuth.getUser().getCart();
    }

    @PostMapping("/{id}")
    public Cart addItem(
            @CookieValue("access-token") @NotBlank(message = "Token is mandatory") @ValidToken(message = "This token is invalid.") String token,
            @PathVariable @NotNull(message = "Item ID is mandatory.") Long id){
        final User user = authService.validateToken(token).getUser();
        return cartService.addItem(user.getCart(), id);
    }

    @DeleteMapping("/{id}")
    public Cart deleteItem(
            @CookieValue("access-token") @NotBlank(message = "Token is mandatory.") @ValidToken String token,
            @PathVariable @NotNull Long id
    ){
        ShopItem toDelete = new ShopItem();
        toDelete.setId(id);
        final User user = authService.validateToken(token).getUser();
        return cartService.deleteItem(user.getCart(), toDelete);
    }
}
