package com.example.easybottest.dto.desktopComputer;

import com.example.easybottest.model.FormFactor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DesktopComputerRequestDTO {
    @NotBlank
    private Long serialNumber;
    private String fabricator;
    private double price;
    private FormFactor formFactor;
}
