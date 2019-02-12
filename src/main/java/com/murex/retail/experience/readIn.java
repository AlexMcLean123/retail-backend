package com.murex.retail.experience;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class readIn {
    public readIn() {
    }

    static final Logger logger = LogManager.getLogger(Main.class);

    public List<ComputerComponent> readIn(String input) throws IOException {
        Path path = Paths.get(input);
        try (Stream<String> lines = Files.lines(path).skip(1)) {
           List<String> inputList= lines.collect(Collectors.toList());
            List<ComputerComponent> componentList = new ArrayList<>();
            for (String s : inputList) {
                String[] array = s.split(",");
                ComputerComponent.ComputerComponentBuilder builder = new ComputerComponent.ComputerComponentBuilder();
                builder.id(array[0].trim())
                        .category(array[1].trim())
                        .name(array[2].trim())
                        .brand(array[3].trim())
                        .productLine(array[4].trim())
                        .coreNum(array[5].trim())
                        .processorSpeed(array[6].trim())
                        .graphicSpeed(array[7].trim())
                        .dimension(array[8].trim())
                        .resolution(array[9].trim())
                        .color(array[10].trim())
                        .interfaceType(array[11].trim())
                        .size(array[12].trim())
                        .price(Integer.parseInt(array[13].trim()))
                        .quantity(Integer.parseInt(array[14].trim()));
                ComputerComponent newComp = builder.build();
                componentList.add(newComp);
                logger.trace(newComp.toString());
            }
            return componentList;
        } catch (IOException e) {
            logger.error(e);
            throw e;
        }
    }
}
