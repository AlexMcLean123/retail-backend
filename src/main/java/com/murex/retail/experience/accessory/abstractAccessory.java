package com.murex.retail.experience.accessory;

import com.murex.retail.experience.computercomponent.AbstractComputerComponent;

public abstract class AbstractAccessory extends AbstractComputerComponent implements Accessory {
    private String color;
    private String dimension;

    protected AbstractAccessory(String id, String category, String name, String brand, String dimension, String color, int price, int quantity) {
        super(id, category, name, brand, price, quantity);
        this.color = color;
        this.dimension = dimension;
    }

    public String getColor() {
        return color;
    }

    public String getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t|\t " + getColor() + "\t|\t" +
                getDimension();

    }
}



