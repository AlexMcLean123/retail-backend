package com.murex.retail.experience.storage;

import com.murex.retail.experience.computercomponent.AbstractComputerComponent;
import org.hibernate.annotations.CollectionId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractStorage extends AbstractComputerComponent {
    @Column(name = "SIZE")
    private String size;
    @Column(name = "MEMORY_INTERFACE")
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
