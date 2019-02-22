package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.*;



public class ReportTest {

    private static Report populatedList;
    private static Report emptyList = new Report(Collections.emptyList());
    private static List<ComputerComponent> comp = new ArrayList<>();


    @BeforeClass
    public static void setUpComponentList() throws SQLException {


        String[] monitorDetails = {"IDMonitor", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};

        String[] mouseDetails = {"IDMouse", "Mouse", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};

        String[] storageDetails = {"IDStorage", "Storage", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "120", "100"};

        String[] keyboardDetails = {"IDKeyboard", "Keyboard", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "170", "100"};

        String[] CPUDetails = {"IDCPU", "CPU", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};

        comp.add(ComputerComponentFactory.newComponent(monitorDetails));
        comp.add(ComputerComponentFactory.newComponent(mouseDetails));
        comp.add(ComputerComponentFactory.newComponent(storageDetails));
        comp.add(ComputerComponentFactory.newComponent(keyboardDetails));
        comp.add(ComputerComponentFactory.newComponent(CPUDetails));
        populatedList = new Report(comp);
    }

    @Test
    public void test_given_empty_list_then_average_price_of_component_is_zero() {
        double v = emptyList.getAveragePrice();

        assertEquals(0.0, v, 0.0);
    }

    @Test
    public void test_given_empty_list_then_first_ten_sorted_will_be_empty_list() {
        List<ComputerComponent> v = emptyList.getSortedList();

        assertTrue(v.isEmpty());
    }


    @Test
    public void test_given_empty_list_then_most_expensive_per_category_is_empty() {
        List<ComputerComponent> v = emptyList.getMostExpensiveByCategory();

        assertTrue(v.isEmpty());
    }

    @Test
    public void test_given_empty_list_then_quantity_per_category_is_empty() {
        Map<String, Integer> v = emptyList.componentQuantityByCategory();

        assertTrue(v.isEmpty());
    }

    @Test
    public void test_given_empty_list_then_number_per_category_and_brand_is_empty() {
        Map<String, Integer> v = emptyList.componentQuantityByCategory();
        assertTrue(v.isEmpty());
    }

    @Test
    public void test_given_components_then_return_list_sorted() {
        comp = populatedList.getSortedList();
        assertNotNull(comp);
        assertEquals("IDCPU", comp.get(0).getId());
        assertEquals("IDKeyboard", comp.get(1).getId());
        assertEquals("IDMonitor", comp.get(2).getId());
        assertEquals("IDMouse", comp.get(3).getId());
        assertEquals("IDStorage", comp.get(4).getId());
    }

    @Test
    public void test_given_components_then_calculate_the_average_price() {
        double d = populatedList.getAveragePrice();
        assertEquals(118.0, d, 0.0);
    }

    @Test
    public void test_given_cpu_components_then_calculate_the_average_price() {
        double d = populatedList.getAveragePriceOfCPU();
        assertEquals(100.0, d,0.0);
    }

    @Test
    public void test_given_components_then_return_cheapest_component() {
        ComputerComponent computerComponent = populatedList.getCheapest();
        assertNotNull(computerComponent);
        assertEquals("IDMonitor", computerComponent.getId());
    }

    @Test
    public void test_given_components_then_return_most_expensive_component_per_category() {
        List<ComputerComponent> mostExpensivePerCategory = populatedList.getMostExpensiveByCategory();
        assertNotNull(mostExpensivePerCategory);
        assertEquals("Storage 120", mostExpensivePerCategory.get(0).getCategory() + " " + mostExpensivePerCategory.get(0).getPrice());
        assertEquals("Monitor 100", mostExpensivePerCategory.get(1).getCategory() + " " + mostExpensivePerCategory.get(1).getPrice());
        assertEquals("Mouse 100", mostExpensivePerCategory.get(2).getCategory() + " " + mostExpensivePerCategory.get(2).getPrice());
    }

    @Test
    public void test_given_components_then_calculate_number_per_category() {
        Map<String, Integer> numPerCat = populatedList.componentQuantityByCategory();
        assertNotNull(numPerCat);
        assertEquals(100, numPerCat.get("Storage").intValue());
        assertEquals(100, numPerCat.get("Keyboard").intValue());
        assertEquals(100, numPerCat.get("CPU").intValue());
    }

    @Test
    public void test_given_components_number_per_category_and_brand() {
        Map<String, Integer> numPerCat = populatedList.componentQuantityByBrandCategory();
        assertNotNull(numPerCat);
        assertEquals(100, numPerCat.get("Keyboard brand").intValue());
        assertEquals(100, numPerCat.get("CPU brand").intValue());
        assertEquals(100, numPerCat.get("Monitor brand").intValue());
        assertEquals(100, numPerCat.get("Mouse brand").intValue());
    }

}