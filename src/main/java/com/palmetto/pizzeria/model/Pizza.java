package com.palmetto.pizzeria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** A pizza item; price is stored in Armenian drams. */
public final class Pizza {
    private final String name;
    private final PizzaSize size;
    private final int priceInDrams;
    private final List<String> toppings = new ArrayList<>();

    public Pizza(String name, PizzaSize size, int priceInDrams) {
        this.name = requireText(name);
        this.size = Objects.requireNonNull(size, "size must not be null");
        if (priceInDrams <= 0) throw new IllegalArgumentException("price must be positive");
        this.priceInDrams = priceInDrams;
    }

    public void addTopping(String topping) { toppings.add(requireText(topping)); }
    public int priceInDrams() { return priceInDrams; }
    public List<String> toppings() { return List.copyOf(toppings); }

    private static String requireText(String value) {
        Objects.requireNonNull(value, "value must not be null");
        if (value.isBlank()) throw new IllegalArgumentException("value must not be blank");
        return value.trim();
    }
}
