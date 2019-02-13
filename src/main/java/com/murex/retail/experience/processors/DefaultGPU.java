package com.murex.retail.experience.processors;

public class DefaultGPU extends AbstractProcessor implements GPU {
    public DefaultGPU(String id, String category, String name, String brand, String productline, String numberOfCores, String processorSpeed, String graphicSpeed, int price, int quantity) {
        super(id, category, name, brand, productline, numberOfCores, processorSpeed, graphicSpeed, price, quantity);
    }



}