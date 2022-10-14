package com.example.demo.services;

import com.example.demo.models.Shop;

import java.util.List;

public interface ShopService {

    List<Shop> getShopList();

    Shop getShopById(int id);

    void saveShop(Shop shop);

    void deleteShopById(int id);
}
