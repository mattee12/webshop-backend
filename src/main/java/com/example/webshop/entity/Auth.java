package com.example.webshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "auth")
@Data
public class Auth {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Id
    private String email;
    private String password;
    private String salt;
    private String token;
}
