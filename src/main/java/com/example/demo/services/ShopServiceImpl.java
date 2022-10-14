package com.example.demo.services;

import com.example.demo.models.Shop;
import com.example.demo.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    @Transactional
    public List<Shop> getShopList () {
        return shopRepository.getShopList();
    }

    @Override
    @Transactional
    public Shop getShopById (int id) {
        return shopRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public void saveShop(Shop shop) {
        shopRepository.save(shop);
    }


    @Override
    @Transactional
    public void deleteShopById(int id) {
        Shop shop = getShopById(id);
        shop.setDeleted(true);
        shopRepository.save(shop);
    }
}
