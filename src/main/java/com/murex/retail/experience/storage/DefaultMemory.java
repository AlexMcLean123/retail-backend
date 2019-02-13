package com.murex.retail.experience.storage;

public class DefaultMemory extends AbstractStorage implements Memory {
    public DefaultMemory(String id, String category, String name, String brand, String size, String memoryInterface, int price, int quantity) {
        super(id, category, name, brand, size, memoryInterface, price, quantity);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
