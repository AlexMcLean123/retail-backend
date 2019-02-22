package com.murex.retail.experience;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.database.ComputerComponentDAO;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {
    private static final String FILE_PATH = "src/main/resources/Inventory.csv";

    @Test
     void testException() {
        FileReader reader = new FileReader();
        Throwable exception = assertThrows(IOException.class, () -> {
            List<ComputerComponent> testFile = reader.readFileSetComponent("notafile");
        });
        assertEquals("Cannot read file: notafile", "Cannot read file: " + exception.getMessage());
    }
    @Test
     void testProgramOutput()throws IOException, SQLException {
        FileReader reader = new FileReader();
        List<ComputerComponent> componentList = reader.readFileSetComponent(FILE_PATH);
        ComputerComponentDAO computerComponentDAO = new ComputerComponentDAO();
        computerComponentDAO.insert(componentList);
        List<ComputerComponent> allComponents = computerComponentDAO.readAll();
        Report report = new Report(allComponents);
        assertItemsSorted(report);
        assertAveragePrice(report);
        assertAveragePriceOfACPU(report);
        assertCheapestComponent(report);
        assertMostExpensiveComponentsInCat(report);
        assertComponentsByCategory(report);
        assertComponentsByBrandCategory(report);
    }

    private void assertItemsSorted(Report report) {
        List<ComputerComponent> sortedInventory = report.getSortedList();
        assertEquals("46100e71-689d-4f37-a94a-9cba59919d8f", sortedInventory.get(0).getId());
        assertEquals("bdf30ee6-665d-484c-af41-917bf9dc6d15", sortedInventory.get(9).getId());
    }

    private void assertAveragePrice(Report report) {
        double temp = report.getAveragePrice();
        assertEquals(145.83, temp);
    }

    private void assertAveragePriceOfACPU(Report report) {
        assertEquals(92.43243243243244, report.getAveragePriceOfCPU());
    }

    private void assertCheapestComponent(Report report) {
       assertEquals(4, report.getCheapest().getPrice());
    }

    private void assertMostExpensiveComponentsInCat(Report report) {
        String[] arrayOfId = {"375cfcec-9655-4c68-9afc-8c706685c883",
                "79b536c7-6a19-4099-96ec-5cdcb33b9548",
                "8611b32f-5efc-4452-9bfe-0f0776c63195",
                "abd86688-2ed5-4a16-af25-e7e2118a1af0",
                "1a4eea28-0681-4ca3-b151-b13ecce8d85d",
                "96fc477c-0c66-4400-9217-94817072429f",
                "ea2b9fd9-d908-4c78-84f0-201483cd91ff"};
        for (int i = 0; i < arrayOfId.length; i++) {
            assertEquals(arrayOfId[i], report.getMostExpensiveByCategory().get(i).getId());
        }
    }

    private void assertComponentsByCategory(Report report) {
        Map<String, Integer> componentsByCat = report.componentQuantityByCategory();
        assertEquals(82, componentsByCat.get("Storage").intValue());
        assertEquals(192, componentsByCat.get("Monitor").intValue());
        assertEquals(141, componentsByCat.get("Memory").intValue());
        assertEquals(312, componentsByCat.get("Mouse").intValue());
        assertEquals(285, componentsByCat.get("Keyboard").intValue());
        assertEquals(1131, componentsByCat.get("CPU").intValue());
        assertEquals(55, componentsByCat.get("GPU").intValue());
    }

    private void assertComponentsByBrandCategory(Report report) {
        Map<String, Integer> brandCategory = report.componentQuantityByBrandCategory();
        assertEquals(90, brandCategory.get("Keyboard logitech").intValue());
        assertEquals(210, brandCategory.get("CPU AMD").intValue());
        assertEquals(153, brandCategory.get("Keyboard Microsoft").intValue());
        assertEquals(15, brandCategory.get("Mouse Kingston").intValue());
        assertEquals(40, brandCategory.get("Mouse Cougar").intValue());
        assertEquals(50, brandCategory.get("Mouse Microsoft").intValue());
        assertEquals(20, brandCategory.get("Monitor ViewSonic").intValue());
        assertEquals(40, brandCategory.get("Memory Team").intValue());
        assertEquals(15, brandCategory.get("Storage Western Digital").intValue());
        assertEquals(80, brandCategory.get("Monitor Asus").intValue());



        assertEquals(55, brandCategory.get("GPU NVIDIA").intValue());
        assertEquals(52, brandCategory.get("Mouse Razer").intValue());
        assertEquals(27, brandCategory.get("Storage Kingston").intValue());
        assertEquals(20, brandCategory.get("Keyboard Apple").intValue());
        assertEquals(921, brandCategory.get("CPU Intel").intValue());
        assertEquals(45, brandCategory.get("Monitor LG").intValue());
        assertEquals(135, brandCategory.get("Mouse CaseLogic").intValue());
        assertEquals(20, brandCategory.get("Mouse Apple").intValue());
        assertEquals(12, brandCategory.get("Memory Patriot").intValue());
        assertEquals(30, brandCategory.get("Storage Seagate").intValue());
        assertEquals(47, brandCategory.get("Monitor Samsung").intValue());
        assertEquals(22, brandCategory.get("Keyboard RAZER").intValue());
        assertEquals(10, brandCategory.get("Storage Samsung").intValue());
        assertEquals(89, brandCategory.get("Memory Kingston").intValue());

    }
}
