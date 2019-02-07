package com.murex.retail.experience;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        readIn reader = new readIn();
        final String CSVFile = "src/main/resources/Inventory.csv";
        List<String> list = reader.readIn(CSVFile);
        List<ComputerComponent> componentList = buildComponent(list);
        Functionalities functions = new Functionalities(componentList);
        functions.sortList(componentList);
        functions.averagePrice(componentList);
        functions.averagePriceOfCPU(componentList);
        functions.printCheapest(componentList);
        functions.mostExpensive();
        functions.componentQuantity();
        functions.componentBrandCategory();
    }

    public static List<ComputerComponent> buildComponent(List<String> inputList) {
        List<ComputerComponent> componentList = new ArrayList<>();
        for (String s : inputList) {
            String[] array = s.split(",");
            ComputerComponent.ComputerComponentBuilder builder = new ComputerComponent.ComputerComponentBuilder();
            builder.id(array[0].trim())
                    .category(array[1].trim())
                    .name(array[2].trim())
                    .brand(array[3].trim())
                    .productLine(array[4].trim())
                    .coreNum(array[5].trim())
                    .processorSpeed(array[6].trim())
                    .graphicSpeed(array[7].trim())
                    .dimension(array[8].trim())
                    .resolution(array[9].trim())
                    .color(array[10].trim())
                    .interfaceType(array[11].trim())
                    .size(array[12].trim())
                    .price(Integer.parseInt(array[13].trim()))
                    .quantity(Integer.parseInt(array[14].trim()));
            ComputerComponent newComp = builder.build();
            componentList.add(newComp);
            logger.trace(newComp.toString());
        }
        return componentList;
    }
}


