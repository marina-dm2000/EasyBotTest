package com.example.easybottest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductType {
    DESKTOP_COMPUTER(Constants.DESKTOP_COMPUTER_NAME),
    LAPTOP(Constants.LAPTOP_NAME),
    SCREEN(Constants.SCREEN_NAME),
    HARD_DISK(Constants.HARD_DISK_NAME);

    private final String name;

    public static class Constants {
        static final String DESKTOP_COMPUTER_NAME = "desktop-computer";
        static final String LAPTOP_NAME = "laptop";
        static final String SCREEN_NAME = "screen";
        static final String HARD_DISK_NAME = "hard-disk";
    }
}
