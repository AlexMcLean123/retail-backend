package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import com.murex.retail.experience.database.ReadData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseExtractor {
    static final Logger LOGGER = LogManager.getLogger(DatabaseExtractor.class);

    public static List<ComputerComponent> extractFromDatabaseMakeComponent(){
        List<String> componentString;
        List<ComputerComponent> componentList = new ArrayList<>();
        try {
            componentString = ReadData.readDataBase();
            for (String x : componentString) {
                String[] componentValues = x.trim().split("\\s*,\\s*");
                componentList.add(ComputerComponentFactory.newComponent(componentValues));
            }
        }
        catch(SQLException e){
            LOGGER.error("Exception caught: " + e);
        }
        return componentList;
    }
}
