package com.example.easybottest.dto.desktopComputer;

import com.example.easybottest.model.FormFactor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesktopComputerUpdateRequestDTO {
    private String fabricator;
    private double price;
    private FormFactor formFactor;
    private int count;
}
