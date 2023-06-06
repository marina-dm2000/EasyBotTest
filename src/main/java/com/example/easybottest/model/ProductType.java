package com.example.easybottest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductType {
    DESKTOP_COMPUTER("desktop-computer"),
    LAPTOP("laptop"),
    SCREEN("screen"),
    HARD_DISK("hard-disk");

    private final String name;
}
