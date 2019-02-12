package com.murex.retail.experience.Storage;

import com.murex.retail.experience.abstractComputerComponent;

public abstract class abstractStorage extends abstractComputerComponent {
    private String size;
    private String memoryInterface;

    public abstractStorage(String id, String category, String name, String brand, String size, String memoryInterface, int price, int quantity) {
        super(id, category, name, brand, price, quantity);
        this.size = size;
        this.memoryInterface = memoryInterface;
    }

    public String getSize() {
        return this.size;
    }


    public String getMemoryInterface() {
        return this.memoryInterface;
    }


    @Override
    public String toString() {
        return getId() + "\t|\t" + getCategory() + "\t|\t" +
                getName() + "\t|\t" + getBrand() + "\t|\t" + getSize() + "\t|\t" + getMemoryInterface() +
                "\t|\t" + getPrice() + "\t|\t"
                + getQuantity();
    }
}
