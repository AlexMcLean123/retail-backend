package com.murex.retail.experience;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        final String CSVFile = "src/main/resources/Inventory.csv";
        List<ComputerComponent> componentList = buildComponent(CSVFile);
        Functionalities functions = new Functionalities(componentList);
        functions.sortList(componentList);
        functions.averagePrice(componentList);
        functions.averagePriceOfCPU();
        functions.getCheapest(componentList);
        functions.getMostExpensiveByCategory();
        functions.componentQuantityByCategory();
        functions.componentQuantityByBrandCategory();
    }

    public static List<ComputerComponent> buildComponent(String input) throws IOException {
        readIn reader = new readIn();
        List<String> listOfComponents = reader.readIn(input);
        List<ComputerComponent> componentList = new ArrayList<>();
        for (String s : listOfComponents) {
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


