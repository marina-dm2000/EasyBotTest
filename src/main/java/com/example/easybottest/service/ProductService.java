package com.example.easybottest.service;

import com.example.easybottest.model.Product;
import com.example.easybottest.model.ProductType;
import com.example.easybottest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository<Product> productRepository;
    private final Map<ProductType, SomeService<?>> productMap;

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Product not found with ID: " + productId));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public <T extends Product> List<T> getBySerialNumber(Long serialNumber) {
        return (List<T>) productRepository.findBySerialNumber(serialNumber);
    }

    public <T extends Product> List<T> getAllByProductType(ProductType productType) {
        return (List<T>) productMap.get(productType).findAll();
    }
}
