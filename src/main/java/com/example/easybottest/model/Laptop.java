package com.example.easybottest.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "laptop")
@AllArgsConstructor
@NoArgsConstructor
public class Laptop extends Product {

    @Column(name = "size", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Size size;

    @Builder
    public Laptop(Long id, Long serialNumber, String fabricator, double price, int count, Size size) {
        super(id, ProductType.LAPTOP, serialNumber, fabricator, price, count);
        this.size = size;
    }
}