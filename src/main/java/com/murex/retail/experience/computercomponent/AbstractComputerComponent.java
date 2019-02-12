package com.murex.retail.experience.computercomponent;

public abstract class AbstractComputerComponent implements ComputerComponent {
    public String id;
    public String category;
    public String name;
    public String brand;
    public int price;
    public int quantity;

    public AbstractComputerComponent(String id, String category, String name, String brand, int price, int quantity) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
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

    @Override
    public String toString() {
        return getId() + "\t|\t" + getCategory() + "\t|\t" +
                getName() + "\t|\t" + getBrand() +
                "\t|\t" + getPrice() + "\t|\t"
                + getQuantity();
    }


}
