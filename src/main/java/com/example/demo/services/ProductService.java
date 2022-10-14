package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.models.Shop;

import java.util.List;

public interface ProductService {

    Product getProductById(int id);

    void saveProduct(Product product);

    void deleteProductById(int id);
}
