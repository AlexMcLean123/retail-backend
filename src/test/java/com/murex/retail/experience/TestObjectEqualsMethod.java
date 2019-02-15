package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.AbstractComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestObjectEqualsMethod {
    @Test
     void testEqualsSameObjectDifferentID(){
        String[] monitorDetails = {"IDMonitor", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent monitor = ComputerComponentFactory.newComponent(monitorDetails);
        String[] mouseDetails = {"IDMonitor2", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent mouse =  ComputerComponentFactory.newComponent(mouseDetails);
        assertEquals(false, mouse.equals(monitor));
    }
    @Test
     void testEqualsSameObjectSameID(){
        String[] monitorDetails = {"IDMonitor2", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent monitor = ComputerComponentFactory.newComponent(monitorDetails);
        String[] mouseDetails = {"IDMonitor2", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent mouse =  ComputerComponentFactory.newComponent(mouseDetails);
        assertEquals(true, mouse.equals(monitor));

    }
    @Test
    void testDifferentObject(){
        String s1="hello";
        String[] monitorDetails = {"IDMonitor2", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent monitor = ComputerComponentFactory.newComponent(monitorDetails);
        assertEquals(false, monitor.equals(s1));
    }
}
