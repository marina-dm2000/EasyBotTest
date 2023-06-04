package com.example.easybottest.dto.hardDisk;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HardDiskRequestDTO {
    @NotBlank
    private Long serialNumber;

    @NotBlank
    private String fabricator;

    @NotBlank
    private double price;

    @NotBlank
    private int volume;

    @NotBlank
    private int count;
}
