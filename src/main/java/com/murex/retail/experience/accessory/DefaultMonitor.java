package com.murex.retail.experience.accessory;

public class DefaultMonitor extends AbstractAccessory implements Monitor {
    protected String resolution;

    public DefaultMonitor(String id, String category, String name, String brand, String dimension, String resolution, String color, int price, int quantity) {
        super(id, category, name, brand, dimension, color, price, quantity);
        this.resolution = resolution;
    }

    public String getResolution() {
        return this.resolution;
    }

    @Override
    public String toString() {
        return super.toString()+ TAB +
                getResolution();
    }
}
