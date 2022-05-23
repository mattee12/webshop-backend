package com.example.webshop.model.enums;

import lombok.Getter;

@Getter
public enum Role {
    USER("user"),
    ADMIN("admin");

    private final String value;

    Role(String value){
        this.value = value;
    }
}
