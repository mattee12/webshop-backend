package com.example.webshop.repository;

import com.example.webshop.entity.ShopItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<ShopItem, Long> {
    @Override
    List<ShopItem> findAll();
}
