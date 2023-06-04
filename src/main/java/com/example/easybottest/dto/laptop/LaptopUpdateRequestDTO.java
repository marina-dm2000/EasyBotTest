package com.example.easybottest.dto.laptop;

import com.example.easybottest.model.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaptopUpdateRequestDTO {
    private String fabricator;
    private double price;
    private Size size;
    private int count;
}
