package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.AbstractComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactoryTest {
    @Test
    void testFactory() {
        String[] monitorDetails = {"IDMonitor", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent monitor = ComputerComponentFactory.newComponent(monitorDetails);
        assertEquals("IDMonitor", monitor.getId());

        String[] mouseDetails = {"IDMouse", "Mouse", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent mouse = ComputerComponentFactory.newComponent(mouseDetails);
        assertEquals("IDMouse", mouse.getId());

        String[] storageDetails = {"IDStorage", "Storage", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent storage = ComputerComponentFactory.newComponent(storageDetails);
        assertEquals("IDStorage", storage.getId());

        String[] keyboardDetails = {"IDKeyboard", "Keyboard", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent keyboard = ComputerComponentFactory.newComponent(keyboardDetails);
        assertEquals("IDKeyboard", keyboard.getId());

        String[] CPUDetails = {"IDCPU", "CPU", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent CPU = ComputerComponentFactory.newComponent(CPUDetails);
        assertEquals("IDCPU", CPU.getId());

        String[] GPUDetails = {"IDGPU", "GPU", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent GPU = ComputerComponentFactory.newComponent(GPUDetails);
        assertEquals("IDGPU", GPU.getId());

        String[] MemoryDetails = {"IDMemory", "Memory", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent Memory = ComputerComponentFactory.newComponent(MemoryDetails);
        assertEquals("IDMemory", Memory.getId());

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String[] ExceptionDetails = {"IDMemory", "Exception", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
            AbstractComputerComponent chair = ComputerComponentFactory.newComponent(ExceptionDetails);
            chair.getId();
        });
        assertEquals("Category not matched: Exception", exception.getMessage());
    }

}

