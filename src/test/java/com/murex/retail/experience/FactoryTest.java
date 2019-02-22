package com.murex.retail.experience;


import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryTest {
    @Test
    public void testFactory() {
        String[] monitorDetails = {"IDMonitor", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent monitor = ComputerComponentFactory.newComponent(monitorDetails);
        assertNotEquals(null, monitor);
        assertEquals("IDMonitor", monitor.getId());

        String[] mouseDetails = {"IDMouse", "Mouse", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent mouse = ComputerComponentFactory.newComponent(mouseDetails);
        assertNotNull(mouse);
        assertEquals("IDMouse", mouse.getId());

        String[] storageDetails = {"IDStorage", "Storage", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent storage = ComputerComponentFactory.newComponent(storageDetails);
        assertNotNull(storage);
        assertEquals("IDStorage", storage.getId());

        String[] keyboardDetails = {"IDKeyboard", "Keyboard", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent keyboard = ComputerComponentFactory.newComponent(keyboardDetails);
        assertNotNull(keyboard);

        assertEquals("IDKeyboard", keyboard.getId());

        String[] CPUDetails = {"IDCPU", "CPU", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent CPU = ComputerComponentFactory.newComponent(CPUDetails);
        assertNotNull(CPU);
        assertEquals("IDCPU", CPU.getId());

        String[] GPUDetails = {"IDGPU", "GPU", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent GPU = ComputerComponentFactory.newComponent(GPUDetails);
        assertNotNull(GPU);
        assertEquals("IDGPU", GPU.getId());

        String[] MemoryDetails = {"IDMemory", "Memory", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent memory = ComputerComponentFactory.newComponent(MemoryDetails);
        assertNotNull(memory);
        assertEquals("IDMemory", memory.getId());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() throws IllegalArgumentException {
        String[] ExceptionDetails = {"IDMemory", "Exception", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        ComputerComponent illegalArgument = ComputerComponentFactory.newComponent(ExceptionDetails);
    }

}

