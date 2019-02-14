package com.murex.retail.experience.computercomponent;

import com.murex.retail.experience.accessory.DefaultKeyboard;
import com.murex.retail.experience.accessory.DefaultMonitor;
import com.murex.retail.experience.accessory.DefaultMouse;
import com.murex.retail.experience.processors.DefaultCPU;
import com.murex.retail.experience.processors.DefaultGPU;
import com.murex.retail.experience.storage.DefaultMemory;
import com.murex.retail.experience.storage.DefaultStorage;

public final class ComputerComponentFactory {
    private ComputerComponentFactory(){

    }
    public static AbstractComputerComponent newComponent(String[] inputArray){
        String id = inputArray[0];
        String category = inputArray[1];
        String name = inputArray[2];
        String brand = inputArray[3];
        String productLine = inputArray[4];
        String coreNum = inputArray[5];
        String processorSpeed = inputArray[6];
        String graphicSpeed = inputArray[7];
        String dimension = inputArray[7];
        String resolution = inputArray[8];
        String color = inputArray[10];
        String interfaceType = inputArray[11];
        String size = inputArray[12];
        int price = Integer.parseInt(inputArray[13]);
        int quantity = Integer.parseInt(inputArray[14]);

        switch (category) {
            case ("Keyboard"):
                return new DefaultKeyboard(id, category, name, brand, dimension, color, price, quantity);

            case ("Mouse"):
                return new DefaultMouse(id, category, name, brand, dimension, color, price, quantity);

            case ("Monitor"):
                return new DefaultMonitor(id, category, name, brand, dimension, resolution, color, price, quantity);

            case ("Memory"):
                return new DefaultMemory(id, category, name, brand, size, interfaceType, price, quantity);

            case ("Storage"):
                return new DefaultStorage(id, category, name, brand, size, dimension, interfaceType, price, quantity);

            case ("CPU"):
                return new DefaultCPU(id, category, name, brand, productLine, coreNum, processorSpeed, graphicSpeed, price, quantity);

            case ("GPU"):
                return new DefaultGPU(id, category, name, brand, productLine, coreNum, processorSpeed, graphicSpeed, price, quantity);

            default:
                throw new IllegalArgumentException("Category not matched: " + category);
        }

    }
}

