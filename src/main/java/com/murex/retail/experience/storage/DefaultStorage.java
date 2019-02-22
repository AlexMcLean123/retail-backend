package com.murex.retail.experience.storage;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class DefaultStorage extends AbstractStorage implements Storage {
    @Column(name = "DIMENSION")
    private String dimension;

    public DefaultStorage(String id, String category, String name, String brand, String dimension, String memoryInterface, String size, int price, int quantity) {
        super(id, category, name, brand, size, memoryInterface, price, quantity);
        this.dimension = dimension;
    }

    public String getDimension() {
        return this.dimension;
    }


    @Override
    public String toString() {
        return super.toString() + "\t|\t" +
                getDimension();
    }
}
