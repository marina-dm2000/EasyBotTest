package com.example.easybottest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenRequestDTO extends ProductRequestDTO {
    private Integer diagonal;

    @Builder
    public ScreenRequestDTO(Long serialNumber, String fabricator, Double price, Integer count, Integer diagonal) {
        super(serialNumber, fabricator, price, count);
        this.diagonal = diagonal;
    }
}
