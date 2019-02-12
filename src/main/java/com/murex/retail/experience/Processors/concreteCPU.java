package com.murex.retail.experience.Processors;

public class concreteCPU extends abstractProcessor implements CPU {
    public concreteCPU(String id, String category, String name, String brand, String productline, String numberOfCores, String processorSpeed, String graphicSpeed, int price, int quantity) {
        super(id, category, name, brand, productline, numberOfCores, processorSpeed, graphicSpeed, price, quantity);
    }
}
