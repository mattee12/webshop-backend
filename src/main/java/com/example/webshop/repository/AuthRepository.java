package com.example.webshop.repository;

import com.example.webshop.entity.Auth;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends CrudRepository<Auth, String>{
    @Query(value = "SELECT a FROM Auth a WHERE a.token = ?1")
    Optional<Auth> findByToken(String token) throws IllegalArgumentException;
}
