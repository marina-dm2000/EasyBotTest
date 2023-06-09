package com.example.easybottest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Screen extends Product {

    @Column(name = "diagonal", nullable = false)
    private int diagonal;

    @Builder
    public Screen(Long id, Long serialNumber, String fabricator, double price, int count, int diagonal) {
        super(id, serialNumber, fabricator, price, count);
        this.diagonal = diagonal;
    }
}