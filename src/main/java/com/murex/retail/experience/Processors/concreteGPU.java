package com.murex.retail.experience.Processors;

public class concreteGPU extends abstractProcessor implements GPU {
    public concreteGPU(String id, String category, String name, String brand, String productline, String numberOfCores, String processorSpeed, String graphicSpeed, int price, int quantity) {
        super(id, category, name, brand, productline, numberOfCores, processorSpeed, graphicSpeed, price, quantity);
    }
}
