package com.example.easybottest.model;

public enum Size {
    _13(13), _14(14), _15(15), _17(17);

    private final int size;

    Size(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
