package com.example.easybottest.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "desktop-computer")
@AllArgsConstructor
@NoArgsConstructor
public class DesktopComputer extends Product {

    @Column(name = "form-factor", nullable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;

    @Builder
    public DesktopComputer(Long id, Long serialNumber, String fabricator, double price, int count, FormFactor formFactor) {
        super(id, ProductType.DESKTOP_COMPUTER, serialNumber, fabricator, price, count);
        this.formFactor = formFactor;
    }
}