package com.example.easybottest.dto.hardDisk;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HardDiskRequestDTO {

    private Long serialNumber;

    private String fabricator;

    private Double price;

    private Integer volume;

    private Integer count;
}
