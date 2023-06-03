package com.example.easybottest.dto.desktopComputer;

import com.example.easybottest.model.FormFactor;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DesktopComputerRequestDTO {
    @NotBlank
    private Long serialNumber;

    @NotBlank
    private String fabricator;

    @NotBlank
    private double price;

    @NotBlank
    private FormFactor formFactor;

    @NotBlank
    private int count;
}
