package com.murex.retail.experience;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class builderTest {
    @Test
    public void testBuilder() {
        ComputerComponent.ComputerComponentBuilder builder = new ComputerComponent.ComputerComponentBuilder();
        builder.id("This is id")
                .category("This is category")
                .name("This is name")
                .brand("This is the brand")
                .productLine("This is the product line")
                .coreNum("This is the number of cores")
                .graphicSpeed("This is the graphics speed")
                .processorSpeed("this is the processor speed")
                .dimension("This is the dimension")
                .resolution("This is the resolution")
                .color("This is the color")
                .interfaceType("this is the interface")
                .size("And this is the size")
                .price(10)
                .quantity(10);
        ComputerComponent newComp = builder.build();

        assertEquals("This is id", newComp.getId());
        assertEquals("This is name", newComp.getName());
        assertEquals("This is the brand", newComp.getBrand());
        assertEquals("This is the product line", newComp.getProductLine());
        assertEquals("This is the number of cores", newComp.getCoreNum());
        assertEquals("This is the graphics speed", newComp.getGraphicSpeed());
        assertEquals("this is the processor speed", newComp.getProcessorSpeed());
        assertEquals("This is the dimension", newComp.getDimension());
        assertEquals("This is the resolution", newComp.getResolution());
        assertEquals("This is the color", newComp.getColor());
        assertEquals("this is the interface", newComp.getInterfaceType());
        assertEquals("And this is the size", newComp.getSize());
        assertEquals(10, newComp.getPrice());
        assertEquals(10, newComp.getQuantity());

    }
}

