package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.AbstractComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {
    @Test
    void testFactory() {
        String[] monitorDetails = {"IDMonitor", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent monitor = ComputerComponentFactory.newComponent(monitorDetails);
        assertNotEquals(null, monitor);
        assertEquals("IDMonitor", monitor.getId());

        String[] mouseDetails = {"IDMouse", "Mouse", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent mouse = ComputerComponentFactory.newComponent(mouseDetails);
        assertNotNull(mouse);
        assertEquals("IDMouse", mouse.getId());

        String[] storageDetails = {"IDStorage", "Storage", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent storage = ComputerComponentFactory.newComponent(storageDetails);
        assertNotNull(storage);
        assertEquals("IDStorage", storage.getId());

        String[] keyboardDetails = {"IDKeyboard", "Keyboard", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent keyboard = ComputerComponentFactory.newComponent(keyboardDetails);
        assertNotNull(keyboard);

        assertEquals("IDKeyboard", keyboard.getId());

        String[] CPUDetails = {"IDCPU", "CPU", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent CPU = ComputerComponentFactory.newComponent(CPUDetails);
        assertNotNull(CPU);
        assertEquals("IDCPU", CPU.getId());

        String[] GPUDetails = {"IDGPU", "GPU", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent GPU = ComputerComponentFactory.newComponent(GPUDetails);
        assertNotNull(GPU);
        assertEquals("IDGPU", GPU.getId());

        String[] MemoryDetails = {"IDMemory", "Memory", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent memory = ComputerComponentFactory.newComponent(MemoryDetails);
        assertNotNull(memory);
        assertEquals("IDMemory", memory.getId());

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String[] ExceptionDetails = {"IDMemory", "Exception", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
            AbstractComputerComponent chair = ComputerComponentFactory.newComponent(ExceptionDetails);
            chair.getId();
        });
        assertEquals("Category not matched: Exception", exception.getMessage());
    }

}

