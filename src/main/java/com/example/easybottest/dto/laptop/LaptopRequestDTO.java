package com.example.easybottest.dto.laptop;

import com.example.easybottest.model.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LaptopRequestDTO {
    private Long serialNumber;

    private String fabricator;

    private Double price;

    private Size size;

    private Integer count;
}
