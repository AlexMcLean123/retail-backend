package com.murex.retail.experience.Storage;

import com.murex.retail.experience.Storage.abstractStorage;

public class concreteMemory extends abstractStorage implements Memory {
    public concreteMemory(String id, String category, String name, String brand, String size, String memoryInterface, int price, int quantity) {
        super(id, category, name, brand, size, memoryInterface, price, quantity);
    }
}
