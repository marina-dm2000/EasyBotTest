package com.example.easybottest.dto.screen;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScreenRequestDTO {
    private Long serialNumber;

    private String fabricator;

    private Double price;

    private Integer diagonal;

    private Integer count;
}
