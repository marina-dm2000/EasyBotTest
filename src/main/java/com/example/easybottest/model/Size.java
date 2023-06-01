package com.example.easybottest.model;

public enum Size {
    A(13),
    B(14),
    C(15),
    D(17);

    private final int size;

    Size(int numVal) {
        this.size = numVal;
    }

    public int getSize() {
        return size;
    }
}
