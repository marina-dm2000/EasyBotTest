package com.example.easybottest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HardDiskRequestDTO extends ProductRequestDTO {
    private Integer volume;

    @Builder
    public HardDiskRequestDTO(Long serialNumber, String fabricator, Double price, Integer count, Integer volume) {
        super(serialNumber, fabricator, price, count);
        this.volume = volume;
    }
}
