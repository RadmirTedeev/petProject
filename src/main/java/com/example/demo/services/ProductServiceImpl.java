package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(int id) {
        return productRepository.getReferenceById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProductById(int id) {
        Product product = getProductById(id);
        product.setDeleted(true);
        productRepository.save(product);
    }
}
