package com.example.demo.repositories;

import com.example.demo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

    @Query(value = "select * from shops as s where s.deleted = false", nativeQuery = true)
    List<Shop> getShopList();
}
