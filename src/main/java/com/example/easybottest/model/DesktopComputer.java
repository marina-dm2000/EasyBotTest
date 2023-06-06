package com.example.easybottest.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.example.easybottest.model.ProductType.Constants.DESKTOP_COMPUTER_NAME;

@Getter
@Setter
@Entity
@DiscriminatorValue(DESKTOP_COMPUTER_NAME)
@AllArgsConstructor
@NoArgsConstructor
public class DesktopComputer extends Product {

    @Column(name = "form-factor", nullable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;

    @Builder
    public DesktopComputer(Long id, Long serialNumber, String fabricator, double price, int count, FormFactor formFactor) {
        super(id, serialNumber, fabricator, price, count);
        this.formFactor = formFactor;
    }
}