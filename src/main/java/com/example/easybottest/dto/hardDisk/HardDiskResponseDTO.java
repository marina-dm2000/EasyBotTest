package com.example.easybottest.dto.hardDisk;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HardDiskResponseDTO {
    private Long id;
    private Long serialNumber;
    private String fabricator;
    private double price;
    private int count;
    private int volume;

}
