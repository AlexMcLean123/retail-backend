package com.murex.retail.experience;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        final String CSVFile = "src/main/resources/Inventory.csv";
        readIn reader = new readIn();
        List<String> listOfInventory = reader.readIn(CSVFile);
        List<ComputerComponent> listOfComponents = reader.setComponent(listOfInventory);
        Functionalities functions = new Functionalities(listOfComponents);
        functions.sortList(listOfComponents);
        functions.averagePrice(listOfComponents);
        functions.averagePriceOfCPU();
        functions.getCheapest(listOfComponents);
        functions.getMostExpensiveByCategory();
        functions.componentQuantityByCategory();
        functions.componentQuantityByBrandCategory();
    }
}


