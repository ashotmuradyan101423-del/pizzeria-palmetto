package com.palmetto.pizzeria.model;

import java.util.Objects;

/** A customer who places an order. */
public record Customer(String fullName, String phoneNumber) {
    public Customer {
        fullName = requireText(fullName, "fullName");
        phoneNumber = requireText(phoneNumber, "phoneNumber");
    }

    private static String requireText(String value, String field) {
        Objects.requireNonNull(value, field + " must not be null");
        if (value.isBlank()) throw new IllegalArgumentException(field + " must not be blank");
        return value.trim();
    }
}
