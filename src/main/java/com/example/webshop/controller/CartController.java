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

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@Validated
@CrossOrigin
public class CartController {
    private final AuthService authService;
    private final CartService cartService;

    @GetMapping("/{token}")
    public Cart getCart(@PathVariable @ValidToken String token){
        final Auth resultAuth = authService.validateToken(token);
        if(resultAuth == null){return null;}
        return resultAuth.getUser().getCart();
    }

    @PostMapping("/{token}/{id}")
    public Cart addItem(
            @PathVariable @ValidToken(message = "This token is invalid.") String token,
            @PathVariable @NotNull(message = "Item ID is mandatory.") Long id){
        final User user = authService.validateToken(token).getUser();
        return cartService.addItem(user.getCart(), id);
    }

    @DeleteMapping("/{token}/{id}")
    public Cart deleteItem(
            @PathVariable @ValidToken String token,
            @PathVariable @NotNull Long id
    ){
        ShopItem toDelete = new ShopItem();
        toDelete.setId(id);
        final User user = authService.validateToken(token).getUser();
        return cartService.deleteItem(user.getCart(), toDelete);
    }
}
