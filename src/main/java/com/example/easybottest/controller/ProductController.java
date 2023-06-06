package com.example.easybottest.controller;

import com.example.easybottest.model.Product;
import com.example.easybottest.model.ProductType;
import com.example.easybottest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{productType}")
    public <T extends Product> List<T> getAllByProductType(@PathVariable String productType) {
        return productService.getAllByProductType(convertNameToProductType(productType));
    }

    @GetMapping("/{serialNumber}")
    public <T extends Product> List<T> getBySerialNumber(@PathVariable Long serialNumber) {
        return productService.getBySerialNumber(serialNumber);
    }

    private static ProductType convertNameToProductType(String name) {
        return Arrays.stream(ProductType.values())
                .filter(type -> Objects.equals(name, type.getName()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
