package com.murex.retail.experience.processors;

import com.murex.retail.experience.computercomponent.AbstractComputerComponent;

public abstract class AbstractProcessor extends AbstractComputerComponent implements Processor {
    private String productline;
    private String numberOfCores;
    private String processorSpeed;
    private String graphicClockSpeed;

    public AbstractProcessor(String id, String category, String name, String brand, String productline, String numberOfCores, String processorSpeed, String graphicClockSpeed, int price, int quantity) {
        super(id, category, name, brand, price, quantity);
        this.productline = productline;
        this.numberOfCores = numberOfCores;
        this.processorSpeed = processorSpeed;
        this.graphicClockSpeed = graphicClockSpeed;
    }

    public String getProuctline() {
        return productline;
    }

    public String getNumberOfCores() {
        return numberOfCores;
    }

    public String getProcessorSpeed() {
        return processorSpeed;
    }

    public String getGraphicClockSpeed() {
        return graphicClockSpeed;
    }

    @Override
    public String toString() {
        return getId() + "\t|\t" +
                getCategory() + "\t|\t" +
                getName() + "\t|\t" +
                getBrand() + "\t|\t" +
                getProuctline() + "\t|\t" +
                getNumberOfCores() + "\t|\t" +
                getProcessorSpeed() + "\t|\t" +
                getGraphicClockSpeed() + "\t|\t" +
                getPrice() + "\t|\t" +
                getQuantity();
    }
}
