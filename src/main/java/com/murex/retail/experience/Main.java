package com.murex.retail.experience;
import com.murex.retail.experience.computercomponent.ComputerComponent;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        final String CSV_FILE = "src/main/resources/Inventory.csv";
        ReadIn reader = new ReadIn();
        List<String> fileInList = reader.readInFileToList(CSV_FILE);
        TruncateTable.truncate();
        DatabaseFunction.insertSQLIntoDatabase(fileInList);
        List<ComputerComponent> listOfComponents = DatabaseFunction.extractFromDatabaseMakeComponent();
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


