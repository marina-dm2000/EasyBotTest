package com.example.easybottest.dto.screen;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenUpdateRequestDTO {
    private String fabricator;
    private double price;
    private int diagonal;
    private int count;
}
