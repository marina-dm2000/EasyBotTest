package com.example.easybottest.dto.desktopComputer;

import com.example.easybottest.model.FormFactor;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DesktopComputerRequestDTO {
    @NotBlank
    private Long serialNumber;

    @NotBlank
    private String fabricator;

    @NotBlank
    private double price;

    @NotBlank
    private FormFactor formFactor;
}
