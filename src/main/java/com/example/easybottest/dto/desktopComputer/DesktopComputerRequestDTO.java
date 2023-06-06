package com.example.easybottest.dto.desktopComputer;

import com.example.easybottest.model.FormFactor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DesktopComputerRequestDTO {
    private Long serialNumber;
    private String fabricator;
    private Double price;
    private FormFactor formFactor;
    private Integer count;
}
