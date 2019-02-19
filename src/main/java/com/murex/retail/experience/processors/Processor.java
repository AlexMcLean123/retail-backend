package com.murex.retail.experience.processors;

import com.murex.retail.experience.computercomponent.ComputerComponent;

public interface Processor extends ComputerComponent {
    String getProductline();

    String getNumberOfCores();

    String getProcessorSpeed();

    String getGraphicClockSpeed();

}
