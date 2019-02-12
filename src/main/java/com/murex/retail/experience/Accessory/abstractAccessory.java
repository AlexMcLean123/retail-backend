package com.murex.retail.experience.Accessory;

import com.murex.retail.experience.abstractComputerComponent;

public abstract class abstractAccessory extends abstractComputerComponent implements Accessory {
    private String color;
    private String dimension;

    protected abstractAccessory(String id, String category, String name, String brand, String dimension, String color, int price, int quantity) {
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
        return getId() + "\t|\t" + getCategory() + "\t|\t" +
                getName() + "\t|\t" + getBrand() +
                "\t|\t" + getDimension() + "\t|\t" + getColor() + "\t|\t" + getPrice() + "\t|\t"
                + getQuantity();
    }

}
