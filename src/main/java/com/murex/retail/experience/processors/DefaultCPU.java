package com.murex.retail.experience.processors;

public class DefaultCPU extends AbstractProcessor implements CPU {
    public DefaultCPU(String id, String category, String name, String brand, String productline, String numberOfCores, String processorSpeed, String graphicSpeed, int price, int quantity) {
        super(id, category, name, brand, productline, numberOfCores, processorSpeed, graphicSpeed, price, quantity);
    }

    @Override
    public String toString() {
        return getId() +
                "\t|\t" + getCategory() +
                "\t|\t" + getName() + "\t|\t" +
                getBrand() + "\t|\t" +
                getProuctline() + "\t|\t" +
                getNumberOfCores() + "\t|\t" +
                getProcessorSpeed() + "\t|\t" +
                getGraphicClockSpeed() + "\t|\t" +
                getPrice() + "\t|\t" +
                getQuantity();
    }
}
