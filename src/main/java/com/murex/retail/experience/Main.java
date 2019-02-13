package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.ComputerComponent;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CSVFile = "src/main/resources/Inventory.csv";
        ReadIn reader = new ReadIn();
        List<ComputerComponent> listOfComponents = reader.readFileSetComponent(CSVFile);
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


