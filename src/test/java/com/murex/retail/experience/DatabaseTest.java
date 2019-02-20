package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.AbstractComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import com.murex.retail.experience.database.ComputerComponentDAO;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private static String[] monitorDetails = {"IDMonitor", "Monitor", "name", "brand", "product", "cores",
            "processor", "resolution", "dimension", "graphic", "color", "interface", "size", "100", "100"};
    @Test
    void testInsertRead() throws SQLException {
        TruncateTable.truncate();
        List<ComputerComponent> listOfComponents = new ArrayList<>();
        List<ComputerComponent> listReturned;
        ComputerComponentDAO computerComponentDAO = new ComputerComponentDAO();
        ComputerComponent monitor = ComputerComponentFactory.newComponent(monitorDetails);
        listOfComponents.add(monitor);
        computerComponentDAO.insert(listOfComponents);
        listReturned = computerComponentDAO.getAll();
        assertNotNull(listReturned);
        assertEquals(listOfComponents.get(0).getId(),listReturned.get(0).getId());
        TruncateTable.truncate();

    }

}
