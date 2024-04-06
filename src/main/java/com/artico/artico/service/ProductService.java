package com.artico.artico.service;


import com.artico.artico.models.Product;
import com.artico.artico.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getRandomProducts(int count) {
        List<Product> randomProducts = new ArrayList<>();

        // Get all products from the database
        List<Product> allProducts = productRepository.findAll();


        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(allProducts.size());
            Product randomProduct = allProducts.get(randomIndex);
            randomProducts.add(randomProduct);
            // Remove the selected product to avoid duplication
            allProducts.remove(randomProduct);
        }

        return randomProducts;
    }
}

