package com.example.easybottest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@AllArgsConstructor
@Getter
public enum ProductType {
    DESKTOP_COMPUTER("desktop-computer"),
    LAPTOP("laptop"),
    SCREEN("screen"),
    HARD_DISK("hard-disk");

    private final String name;

    public static ProductType convertNameToProductType(String name) {
        return Arrays.stream(ProductType.values())
                .filter(type -> Objects.equals(name, type.getName()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
