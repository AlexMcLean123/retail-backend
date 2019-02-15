package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import com.murex.retail.experience.database.InputToSQL;
import com.murex.retail.experience.database.ReadData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadIn {
    public ReadIn() {
    }

    static final Logger LOGGER = LogManager.getLogger(ReadIn.class);

    public List<ComputerComponent> addToDatabase(String inputPath) {
        List<ComputerComponent> componentList = new ArrayList<>();
        try {
            DatabaseFunction.insertSQLIntoDatabase(readInFileToList(inputPath));
        } catch (IOException e) {
            LOGGER.error("Exception caught: " + e);
        }
        return componentList;
    }


    public List<String> readInFileToList(String input) throws IOException {
        Path path = Paths.get(input);
        try (Stream<String> lines = Files.lines(path).skip(1)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw e;
        }
    }


}
