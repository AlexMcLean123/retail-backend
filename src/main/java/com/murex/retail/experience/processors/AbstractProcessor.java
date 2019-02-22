package com.murex.retail.experience.processors;

import com.murex.retail.experience.computercomponent.AbstractComputerComponent;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractProcessor extends AbstractComputerComponent implements Processor {
    @Column(name = "PRODUCT_LINE")
    private String productline;
    @Column(name = "NUMBER_OF_CORES")
    private String numberOfCores;
    @Column(name = "PROCESSOR_SPEED")
    private String processorSpeed;
    @Column(name = "GRAPHIC_CLOCK_SPEED")
    private String graphicClockSpeed;

    public AbstractProcessor(String id, String category, String name, String brand, String productline, String numberOfCores, String processorSpeed, String graphicClockSpeed, int price, int quantity) {
        super(id, category, name, brand, price, quantity);
        this.productline = productline;
        this.numberOfCores = numberOfCores;
        this.processorSpeed = processorSpeed;
        this.graphicClockSpeed = graphicClockSpeed;
    }

    public String getProductline() {
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
        return getId() + TAB +
                getCategory() + TAB +
                getName() + TAB +
                getBrand() + TAB +
                getProductline() + TAB  +
                getNumberOfCores() + TAB +
                getProcessorSpeed() + TAB +
                getGraphicClockSpeed() + TAB +
                getPrice() + TAB +
                getQuantity();
    }
}
