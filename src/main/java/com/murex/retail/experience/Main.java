package com.murex.retail.experience;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        final String CSVFile = "src/main/resources/Inventory.csv";
        readIn reader = new readIn();
        List<ComputerComponent> componentList = reader.readIn(CSVFile);
        Functionalities functions = new Functionalities(componentList);
        functions.sortList(componentList);
        functions.averagePrice(componentList);
        functions.averagePriceOfCPU();
        functions.getCheapest(componentList);
        functions.getMostExpensiveByCategory();
        functions.componentQuantityByCategory();
        functions.componentQuantityByBrandCategory();
    }
}


