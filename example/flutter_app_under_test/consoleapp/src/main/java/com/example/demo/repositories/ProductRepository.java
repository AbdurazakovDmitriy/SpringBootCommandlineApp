package com.example.demo.repositories;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
     List<Product> saveAll(List<Product> products);
}
