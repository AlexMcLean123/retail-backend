package com.murex.retail.experience.accessory;

public class DefaultMouse extends AbstractAccessory implements Mouse {
    public DefaultMouse(String id, String category, String name, String brand, String dimension, String color, int price, int quantity) {
        super(id, category, name, brand, dimension, color, price, quantity);
    }

    @Override
    public String toString() {
        return getId() + "\t|\t" +
                getCategory() + "\t|\t" +
                getName() + "\t|\t" +
                getBrand() + "\t|\t" +
                getDimension() + "\t|\t" +
                getColor() + "\t|\t" +
                getPrice() + "\t|\t" +
                getQuantity();
    }
}
