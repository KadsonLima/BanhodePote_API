package com.banhodepote.api.enums;

public enum CategoryFood {
    PETISCO(1),
    PRATO(2),
    BEBIDAS(3);

    private final int value;

    private CategoryFood(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CategoryFood fromValue(int value) {
        for (CategoryFood category : CategoryFood.values()) {
            if (category.getValue() == value) {
                return category;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}