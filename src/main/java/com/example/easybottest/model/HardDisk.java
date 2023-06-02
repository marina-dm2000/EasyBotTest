package com.example.easybottest.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "hard-disk")
@NoArgsConstructor
@AllArgsConstructor
public class HardDisk extends Product {

    @Column(name = "volume", nullable = false)
    private int volume;

    @Builder
    public HardDisk(Long id, Long serialNumber, String fabricator, double price, int count, int volume) {
        super(id, ProductType.HARD_DISK, serialNumber, fabricator, price, count);
        this.volume = volume;
    }
}