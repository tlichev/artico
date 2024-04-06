package com.artico.artico.repository;

import com.artico.artico.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

// retrieval of DB product info
public interface ProductRepository extends JpaRepository<Product, Long> {
    // basic CRUD operations defined by default
}

