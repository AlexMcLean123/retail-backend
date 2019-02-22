package com.murex.retail.experience.processors;

import javax.persistence.Entity;

@Entity
public class DefaultCPU extends AbstractProcessor implements CPU {
    public DefaultCPU(String id, String category, String name, String brand, String productline, String numberOfCores, String processorSpeed, String graphicSpeed, int price, int quantity) {
        super(id, category, name, brand, productline, numberOfCores, processorSpeed, graphicSpeed, price, quantity);
    }


}
