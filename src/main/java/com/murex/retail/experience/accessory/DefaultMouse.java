package com.murex.retail.experience.accessory;

public class DefaultMouse extends AbstractAccessory implements Mouse {
    public DefaultMouse(String id, String category, String name, String brand, String dimension, String color, int price, int quantity) {
        super(id, category, name, brand, dimension, color, price, quantity);
    }


    public String toString() {
        return super.toString();
    }
}
