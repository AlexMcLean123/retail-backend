package com.murex.retail.experience;


import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    static final Logger LOGGER = LogManager.getLogger(FileReader.class);

    public FileReader() {
    }


    public List<ComputerComponent> readFileSetComponent(String inputPath) throws IOException {
        Path path = Paths.get(inputPath);
        try (Stream<String> lines = Files.lines(path).skip(1)) {
            return lines.map(s -> s.split("\\s*,\\s*")).map(ComputerComponentFactory::newComponent).collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error(e);
            throw e;
        }
    }
}
