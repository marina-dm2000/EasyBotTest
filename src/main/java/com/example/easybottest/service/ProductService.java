package com.example.easybottest.service;

import com.example.easybottest.model.Product;
import com.example.easybottest.repository.ProductRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;

import java.util.List;

public interface ProductService<T extends Product, E extends ProductRepository<T>> {

    public T getProductById(Long productId);

    public List<T> findAll();

}
