package com.example.easybottest.dto.desktopComputer;

import com.example.easybottest.model.FormFactor;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DesktopComputerResponseDTO {
    private Long id;
    private Long serialNumber;
    private String fabricator;
    private double price;
    private FormFactor formFactor;
    private int count;
}
