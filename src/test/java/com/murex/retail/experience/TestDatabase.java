package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.database.InputToSQL;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDatabase {
    static String[] monitorDetails = {"IDMonitor", "Monitor", "name", "brand", "product", "cores",
            "processor", "resolution", "dimension", "graphic", "color", "interface", "size", "100", "100"};
    @Test
    void testInsertRead() throws SQLException {
        TruncateTable.truncate();
        InputToSQL.parseToSQL(monitorDetails);
        List<ComputerComponent> listOfComponents = DatabaseFunction.extractFromDatabaseMakeComponent();
       assertEquals("IDMonitor	|	Monitor	|	name	|	brand	|	100	|	100	|	 color	|	resolution	|	dimension", listOfComponents.get(0).toString());
    }

}
