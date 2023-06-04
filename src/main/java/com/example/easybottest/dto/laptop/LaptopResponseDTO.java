package com.example.easybottest.dto.laptop;

import com.example.easybottest.model.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LaptopResponseDTO {
    private Long id;
    private Long serialNumber;
    private String fabricator;
    private double price;
    private int count;
    private Size size;
}
