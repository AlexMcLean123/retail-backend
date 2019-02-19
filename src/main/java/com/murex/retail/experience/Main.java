package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.database.ComputerComponentDAO;

import java.util.List;

public class Main {

    public static final String CSV_FILE = "src/main/resources/Inventory.csv";

    public static void main(String[] args) throws Exception {
        TruncateTable.truncate();
        FileReader reader = new FileReader();
        List<ComputerComponent> componentList = reader.readFileSetComponent(CSV_FILE);
        ComputerComponentDAO computerComponentDAO = new ComputerComponentDAO();
        for (ComputerComponent x : componentList) {
            computerComponentDAO.insert(x);
        }
        List<ComputerComponent> listOfComponents = computerComponentDAO.getAll();
        Report report = new Report(listOfComponents);
        report.getSortedList();
        report.getAveragePrice();
        report.getAveragePriceOfCPU();
        report.getCheapest();
        report.getMostExpensiveByCategory();
        report.componentQuantityByCategory();
        report.componentQuantityByBrandCategory();
    }
}



