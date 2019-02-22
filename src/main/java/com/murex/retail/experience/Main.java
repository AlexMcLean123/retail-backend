package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.database.ComputerComponentDAO;

import java.util.List;

public class Main {

    public static final String CSV_FILE = "src/main/resources/Inventory.csv";

    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader();
        List<ComputerComponent> componentList = reader.readFileSetComponent(CSV_FILE);
        ComputerComponentDAO computerComponentDAO = new ComputerComponentDAO();
        computerComponentDAO.insert(componentList);
        List<ComputerComponent> listOfComponents = computerComponentDAO.readAll();
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



