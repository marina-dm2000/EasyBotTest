package com.example.easybottest.dto.hardDisk;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HardDiskUpdateRequestDTO {
    private String fabricator;
    private double price;
    private int volume;
    private int count;
}
