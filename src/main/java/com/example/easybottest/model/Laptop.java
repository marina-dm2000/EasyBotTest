package com.example.easybottest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Laptop extends Product {

    @Column(name = "size", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Size size;

    @Builder
    public Laptop(Long id, Long serialNumber, String fabricator, double price, int count, Size size) {
        super(id, serialNumber, fabricator, price, count);
        this.size = size;
    }
}