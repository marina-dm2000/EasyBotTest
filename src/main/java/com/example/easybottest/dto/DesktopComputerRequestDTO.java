package com.example.easybottest.dto;

import com.example.easybottest.model.FormFactor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesktopComputerRequestDTO extends ProductRequestDTO {
    private FormFactor formFactor;

    @Builder
    public DesktopComputerRequestDTO(Long serialNumber, String fabricator, Double price, Integer count, FormFactor formFactor) {
        super(serialNumber, fabricator, price, count);
        this.formFactor = formFactor;
    }
}
