package com.murex.retail.experience;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadIn {
    public ReadIn() {
    }

    static final Logger LOGGER = LogManager.getLogger(ReadIn.class);


    public List<String> readInFileToList(String input) throws IOException {
        Path path = Paths.get(input);
        try (Stream<String> lines = Files.lines(path).skip(1)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw e;
        }
    }
}
