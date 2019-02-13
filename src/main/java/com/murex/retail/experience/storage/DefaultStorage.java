package com.murex.retail.experience.storage;

public class DefaultStorage extends AbstractStorage implements Storage {

    private String dimension;

    public DefaultStorage(String id, String category, String name, String brand, String size, String dimension, String memoryInterface, int price, int quantity) {
        super(id, category, name, brand, size, memoryInterface, price, quantity);
        this.dimension = dimension;
    }

    public String getDimension() {
        return this.dimension;
    }


    @Override
    public String toString() {
        return super.toString() +"\t|\t"+
                getDimension();
    }
}
