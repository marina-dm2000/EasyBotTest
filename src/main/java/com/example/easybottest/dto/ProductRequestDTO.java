package com.example.easybottest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequestDTO {
    private Long serialNumber;
    private String fabricator;
    private Double price;
    private Integer count;
}