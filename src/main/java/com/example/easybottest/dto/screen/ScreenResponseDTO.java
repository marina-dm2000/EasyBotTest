package com.example.easybottest.dto.screen;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScreenResponseDTO {
    private Long id;
    private Long serialNumber;
    private String fabricator;
    private double price;
    private int count;
    private int diagonal;
}
