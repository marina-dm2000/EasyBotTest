package com.example.easybottest.dto;

import com.example.easybottest.model.FormFactor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DesktopComputerDTO {
    private Long id;
    private Long serialNumber;
    private String fabricator;
    private double price;
    private int count;
    private FormFactor formFactor;
}
