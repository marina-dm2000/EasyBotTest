package com.example.easybottest.dto.desktopComputer;

import com.example.easybottest.model.FormFactor;
import lombok.Data;

@Data
public class DesktopComputerRequestDTO {
    private Long serialNumber;
    private String fabricator;
    private double price;
    private FormFactor formFactor;
}
