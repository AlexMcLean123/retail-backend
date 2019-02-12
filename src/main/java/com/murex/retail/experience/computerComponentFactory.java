package com.murex.retail.experience;

import com.murex.retail.experience.Accessory.concreteKeyboard;
import com.murex.retail.experience.Accessory.concreteMonitor;
import com.murex.retail.experience.Accessory.concreteMouse;
import com.murex.retail.experience.Processors.concreteCPU;
import com.murex.retail.experience.Processors.concreteGPU;
import com.murex.retail.experience.Storage.concreteMemory;
import com.murex.retail.experience.Storage.concreteStorage;

public class computerComponentFactory {

    public static abstractComputerComponent getComponent(String[] inputArray) throws IllegalAccessException {

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
            case ("Keyboard"): {
                return new concreteKeyboard(id, category, name, brand, dimension, color, price, quantity);
            }
            case ("Mouse"): {
                return new concreteMouse(id, category, name, brand, dimension, color, price, quantity);
            }
            case ("Monitor"): {
                return new concreteMonitor(id, category, name, brand, dimension, resolution, color, price, quantity);
            }
            case ("Memory"): {
                return new concreteMemory(id, category, name, brand, size, interfaceType, price, quantity);
            }
            case ("Storage"): {
                return new concreteStorage(id, category, name, brand, size, dimension, interfaceType, price, quantity);
            }
            case ("CPU"): {
                return new concreteCPU(id, category, name, brand, productLine, coreNum, processorSpeed, graphicSpeed, price, quantity);
            }
            case ("GPU"): {
                return new concreteGPU(id, category, name, brand, productLine, coreNum, processorSpeed, graphicSpeed, price, quantity);
            }
            default: {
                throw new IllegalAccessException("Category not matched");
            }
        }

    }
}

