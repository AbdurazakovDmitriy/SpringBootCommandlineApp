package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }
}
