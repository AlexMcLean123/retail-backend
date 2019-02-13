package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.AbstractComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class factoryTest {
    @Test
    void testFactory() throws IllegalAccessException {
        String[] monitorDetails = {"IDmonitor", "Monitor", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent monitor = new ComputerComponentFactory().newComponent(monitorDetails);
        assertEquals("IDmonitor", monitor.getId());

        String[] mouseDetails = {"IDmouse", "Mouse", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent mouse = new ComputerComponentFactory().newComponent(mouseDetails);
        assertEquals("IDmouse", mouse.getId());

        String[] storageDetails = {"IDStorage", "Storage", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent storage = new ComputerComponentFactory().newComponent(storageDetails);
        assertEquals("IDStorage", storage.getId());

        String[] KeyboardDetails = {"IDKeyboard", "Keyboard", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent Keyboard = new ComputerComponentFactory().newComponent(KeyboardDetails);
        assertEquals("IDKeyboard", Keyboard.getId());

        String[] CPUDetails = {"IDCPU", "CPU", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent CPU = new ComputerComponentFactory().newComponent(CPUDetails);
        assertEquals("IDCPU", CPU.getId());

        String[] GPUDetails = {"IDGPU", "GPU", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent GPU = new ComputerComponentFactory().newComponent(GPUDetails);
        assertEquals("IDGPU", GPU.getId());

        String[] MemoryDetails = {"IDMemory", "Memory", "name", "brand", "product", "cores", "processor", "graphic", "dimension", "resolution", "color", "interface", "size", "100", "100"};
        AbstractComputerComponent Memory = new ComputerComponentFactory().newComponent(MemoryDetails);
        assertEquals("IDMemory", Memory.getId());

    }
}
