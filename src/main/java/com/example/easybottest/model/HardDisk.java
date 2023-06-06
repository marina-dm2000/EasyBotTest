package com.example.easybottest.model;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.example.easybottest.model.ProductType.Constants.HARD_DISK_NAME;

@Getter
@Setter
@Entity
@DiscriminatorValue(HARD_DISK_NAME)
@NoArgsConstructor
@AllArgsConstructor
public class HardDisk extends Product {

    @Column(name = "volume", nullable = false)
    private int volume;

    @Builder
    public HardDisk(Long id, Long serialNumber, String fabricator, double price, int count, int volume) {
        super(id, serialNumber, fabricator, price, count);
        this.volume = volume;
    }
}