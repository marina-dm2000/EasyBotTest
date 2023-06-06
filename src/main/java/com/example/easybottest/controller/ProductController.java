package com.example.easybottest.controller;

import com.example.easybottest.model.Product;
import com.example.easybottest.model.ProductType;
import com.example.easybottest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/type/{productType}")
    public <T extends Product> ResponseEntity<List<T>> getAllByProductType(@PathVariable String productType) {
        List<T> products = productService.getAllByProductType(ProductType.convertNameToProductType(productType));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/number/{serialNumber}")
    public <T extends Product> ResponseEntity<List<T>> getBySerialNumber(@PathVariable Long serialNumber) {
        List<T> products = productService.getBySerialNumber(serialNumber);
        return ResponseEntity.ok(products);
    }
}
