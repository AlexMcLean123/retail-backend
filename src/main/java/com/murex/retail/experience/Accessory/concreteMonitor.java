package com.murex.retail.experience.Accessory;

import com.murex.retail.experience.Accessory.abstractAccessory;

public class concreteMonitor extends abstractAccessory implements Monitor {
    protected String resolution;

    public concreteMonitor(String id, String category, String name, String brand, String dimension, String resolution, String color, int price, int quantity) {
        super(id, category, name, brand, dimension, color, price, quantity);
        this.resolution = resolution;
    }

    public String getResolution() {
        return this.resolution;
    }

}
