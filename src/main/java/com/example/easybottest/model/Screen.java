package com.example.easybottest.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "screen")
@NoArgsConstructor
@AllArgsConstructor
public class Screen extends Product {

    @Column(name = "diagonal", nullable = false)
    private int diagonal;

    @Builder
    public Screen(Long id, Long serialNumber, String fabricator, double price, int count, int diagonal) {
        super(id, ProductType.SCREEN, serialNumber, fabricator, price, count);
        this.diagonal = diagonal;
    }
}