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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadIn {
    public ReadIn() {
    }

    static final Logger logger = LogManager.getLogger(ReadIn.class);

    public List<String> readInFileToList(String input) throws IOException {
        Path path = Paths.get(input);
        try (Stream<String> lines = Files.lines(path).skip(1)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error(e);
            throw e;
        }
    }

    public List<ComputerComponent> createComponents(String inputPath) throws Exception {
        List<String> componentString;
        List<ComputerComponent> componentList = new ArrayList<>();
        insertIntoDatabase(readInFileToList(inputPath));
        componentString = ReadData.readDataBase();
        for (String x : componentString) {
            String[] componentValues = x.trim().split("\\s*,\\s*");
            componentList.add(ComputerComponentFactory.newComponent(componentValues));
        }
        return componentList;
    }

    public void insertIntoDatabase(List<String> componentList) throws Exception {
        for (String x : componentList) {
            String[] componentValues = x.trim().split("\\s*,\\s*");
            InputToSQL.parseToSQL(componentValues);
        }
    }
}
