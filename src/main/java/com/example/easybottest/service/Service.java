package com.example.easybottest.service;

import com.example.easybottest.model.Product;
import com.example.easybottest.model.ProductType;

import java.util.List;

public interface Service<T extends Product> {

    T getProductById(Long productId);

    List<T> findAll();

    ProductType getProductType();
}
