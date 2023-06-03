package com.example.easybottest.service;

import com.example.easybottest.model.Product;
import com.example.easybottest.repository.ProductRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;

import java.util.List;

public abstract class ProductService<T extends Product, E extends ProductRepository<T>> {
    private final E productRepository;
    public ProductService(E productRepository) {
        this.productRepository = productRepository;
    }

    public T getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Desktop computer not found with ID: " + productId));
    }

    public List<T> findAllProduct() {
        return productRepository.findAll();
    }

}
