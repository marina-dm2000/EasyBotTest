package com.example.easybottest.dto;

import com.example.easybottest.model.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaptopRequestDTO extends ProductRequestDTO {

    private Size size;

    @Builder
    public LaptopRequestDTO(Long serialNumber, String fabricator, Double price, Integer count, Size size) {
        super(serialNumber, fabricator, price, count);
        this.size = size;
    }
}
