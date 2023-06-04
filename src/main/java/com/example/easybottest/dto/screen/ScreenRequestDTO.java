package com.example.easybottest.dto.screen;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScreenRequestDTO {
    @NotBlank
    private Long serialNumber;

    @NotBlank
    private String fabricator;

    @NotBlank
    private double price;

    @NotBlank
    private int diagonal;

    @NotBlank
    private int count;
}
