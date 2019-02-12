package com.murex.retail.experience.storage;

public class concreteStorage extends abstractStorage implements Storage {

    private String dimension;

    public concreteStorage(String id, String category, String name, String brand, String size, String dimension, String memoryInterface, int price, int quantity) {
        super(id, category, name, brand, size, memoryInterface, price, quantity);
        this.dimension = dimension;
    }

    public String getDimension() {
        return this.dimension;
    }
}
