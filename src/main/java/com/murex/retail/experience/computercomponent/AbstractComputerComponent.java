package com.murex.retail.experience.computercomponent;

public abstract class AbstractComputerComponent implements ComputerComponent {
    public String id;
    public String category;
    public String name;
    public String brand;
    public int price;
    public int quantity;
    public final String TAB = "\t|\t";

    public AbstractComputerComponent(String id, String category, String name, String brand, int price, int quantity) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }


    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return getId() + TAB +
                getCategory() + TAB +
                getName() + TAB +
                getBrand() + TAB +
                getPrice() + TAB +
                getQuantity();
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof ComputerComponent))
            return false;
        ComputerComponent object = (ComputerComponent) obj;
        if (obj == this)
            return true;
        return (this.getId() == object.getId()
                && this.getName() == object.getName());
    }

}

