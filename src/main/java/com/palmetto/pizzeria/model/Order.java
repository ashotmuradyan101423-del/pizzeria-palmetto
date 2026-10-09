package com.palmetto.pizzeria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** A collection of pizzas ordered by one customer. */
public final class Order {
    private final String orderNumber;
    private final Customer customer;
    private final List<Pizza> pizzas = new ArrayList<>();
    private OrderStatus status = OrderStatus.NEW;

    public Order(String orderNumber, Customer customer) {
        this.orderNumber = Objects.requireNonNull(orderNumber, "orderNumber must not be null");
        this.customer = Objects.requireNonNull(customer, "customer must not be null");
    }

    public void addPizza(Pizza pizza) {
        if (status != OrderStatus.NEW) throw new IllegalStateException("Order cannot be changed");
        pizzas.add(Objects.requireNonNull(pizza, "pizza must not be null"));
    }

    public void confirm() {
        if (pizzas.isEmpty()) throw new IllegalStateException("An order needs a pizza");
        status = OrderStatus.CONFIRMED;
    }

    public int totalInDrams() { return pizzas.stream().mapToInt(Pizza::priceInDrams).sum(); }

    public String summary() {
        return "%s for %s: %d pizza(s), %,d AMD [%s]".formatted(
                orderNumber, customer.fullName(), pizzas.size(), totalInDrams(), status);
    }
}
