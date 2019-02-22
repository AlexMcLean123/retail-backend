package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestObjectEqualsMethod {
    @Test
    public void testEqualsSameObjectDifferentID() {
        String[] monitorDetails = {"IDMonitor", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent monitor = ComputerComponentFactory.newComponent(monitorDetails);
        String[] mouseDetails = {"IDMonitor2", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent mouse = ComputerComponentFactory.newComponent(mouseDetails);
        assertEquals(false, mouse.equals(monitor));
    }

    @Test
    public void testEqualsSameObjectSameID() {
        String[] monitorDetails = {"IDMonitor2", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent monitor = ComputerComponentFactory.newComponent(monitorDetails);
        String[] mouseDetails = {"IDMonitor2", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent mouse = ComputerComponentFactory.newComponent(mouseDetails);
        assertEquals(true, mouse.equals(monitor));

    }

    @Test
    public void testDifferentObject() {
        String s1 = "hello";
        String[] monitorDetails = {"IDMonitor2", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent monitor = ComputerComponentFactory.newComponent(monitorDetails);
        assertFalse( monitor.equals(s1));
    }
}
