package com.example.easybottest.dto;

import com.example.easybottest.model.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequestDTO {
    private Long serialNumber;
    private String fabricator;
    private Double price;
    private Integer count;
}