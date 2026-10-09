package com.palmetto.pizzeria;

import com.palmetto.pizzeria.model.Customer;
import com.palmetto.pizzeria.model.Order;
import com.palmetto.pizzeria.model.Pizza;
import com.palmetto.pizzeria.model.PizzaSize;

/** Application entry point for a sample Pizzeria Palmetto order. */
public final class App {
    private App() { }

    public static void main(String[] args) {
        Customer customer = new Customer("Ashot Muradyan", "+374 00 000000");
        Pizza pizza = new Pizza("Margherita", PizzaSize.MEDIUM, 3500);
        pizza.addTopping("Basil");

        Order order = new Order("PP-1001", customer);
        order.addPizza(pizza);
        order.confirm();
        System.out.println(order.summary());
    }
}
