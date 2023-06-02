package com.example.easybottest.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private ProductType type;

    @Column(name = "serial-number", nullable = false, unique = true)
    private Long serialNumber;

    @Column(name = "fabricator", nullable = false)
    private String fabricator;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "count", nullable = false)
    private int count;
}
