package com.example.easybottest.dto.laptop;

import com.example.easybottest.model.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LaptopRequestDTO {
    @NotBlank
    private Long serialNumber;

    @NotBlank
    private String fabricator;

    @NotBlank
    private double price;

    @NotBlank
    private Size size;

    @NotBlank
    private int count;
}
