package com.murex.retail.experience.storage;

import com.murex.retail.experience.computercomponent.AbstractComputerComponent;

public abstract class AbstractStorage extends AbstractComputerComponent {
    private String size;
    private String memoryInterface;

    public AbstractStorage(String id, String category, String name, String brand, String size, String memoryInterface, int price, int quantity) {
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
        return getId() + TAB + getCategory() + TAB +
                getName() + TAB + getBrand() + TAB + getSize() + TAB + getMemoryInterface() +
                TAB + getPrice() + TAB
                + getQuantity();
    }
}
