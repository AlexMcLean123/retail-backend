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

    public List<String> readIn(String input) throws IOException {
        Path path = Paths.get(input);
        try (Stream<String> lines = Files.lines(path).skip(1)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error(e);
            throw e;
        }
    }

    public List<ComputerComponent> setComponent(List<String> componentString) throws IllegalAccessException{
        List<ComputerComponent> componentList = new ArrayList<>();
        for (String x : componentString) {
            String theLine[] = x.trim().split("\\s*,\\s*");
            componentList.add(computerComponentFactory.getComponent(theLine));
        }
        return componentList;
    }
}
