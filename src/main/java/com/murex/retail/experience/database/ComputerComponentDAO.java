package com.murex.retail.experience.database;

import com.murex.retail.experience.accessory.DefaultKeyboard;
import com.murex.retail.experience.accessory.DefaultMonitor;
import com.murex.retail.experience.accessory.DefaultMouse;
import com.murex.retail.experience.computercomponent.ComputerComponent;
import com.murex.retail.experience.computercomponent.ComputerComponentFactory;
import com.murex.retail.experience.processors.DefaultCPU;
import com.murex.retail.experience.processors.DefaultGPU;
import com.murex.retail.experience.storage.DefaultMemory;
import com.murex.retail.experience.storage.DefaultStorage;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerComponentDAO {

    private final DataSource dataSource;

    public ComputerComponentDAO() {
        this.dataSource = new DBConnectionPool().setUp();
    }

    public void insert(ComputerComponent computerComponent) throws SQLException {
        String[] array = getComputerComponentAsString(computerComponent);
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO COMPUTER_COMPONENT(ID,CATEGORY, NAME,BRAND,PRODUCT_LINE," +
                     "NUMBER_OF_CORES,PROCESSOR_CLOCK_SPEED,GRAPHIC_CLOCK_SPEED, DIMENSION, RESOLUTION," +
                     "COLOR,INTERFACE,SIZE,PRICE,QUANTITY) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);")) {
            String[] computerComponentAsString = getComputerComponentAsString(computerComponent);
            stmt.setString(1, computerComponentAsString[0]);
            stmt.setString(2, computerComponentAsString[1]);
            stmt.setString(3, computerComponentAsString[2]);
            stmt.setString(4, computerComponentAsString[3]);
            stmt.setString(5, computerComponentAsString[4]);
            stmt.setString(6, computerComponentAsString[5]);
            stmt.setString(7, computerComponentAsString[6]);
            stmt.setString(8, computerComponentAsString[7]);
            stmt.setString(9, computerComponentAsString[8]);
            stmt.setString(10, computerComponentAsString[9]);
            stmt.setString(11, computerComponentAsString[10]);
            stmt.setString(12, computerComponentAsString[11]);
            stmt.setString(13, computerComponentAsString[12]);
            stmt.setInt(14, computerComponent.getPrice());
            stmt.setInt(15, computerComponent.getQuantity());
            stmt.execute();

        } catch (SQLException e) {


        }
    }

    private String[] getComputerComponentAsString(ComputerComponent computerComponent) {
        switch (computerComponent.getCategory()) {
            case "Keyboard":
                DefaultKeyboard keyboard = (DefaultKeyboard) computerComponent;
                return new String[]{keyboard.getId(), keyboard.getCategory(), keyboard.getName(), keyboard.getBrand(), "N/A", "N/A", "N/A", "N/A",
                        keyboard.getDimension(), "N/A", keyboard.getColor(), "N/A", "N/A", (Integer.toString(keyboard.getPrice())), (Integer.toString(keyboard.getQuantity()))};

            case "Mouse":
                DefaultMouse mouse = (DefaultMouse) computerComponent;
                return new String[]{mouse.getId(), mouse.getCategory(), mouse.getName(), mouse.getBrand(), "N/A", "N/A", "N/A", "N/A",
                        mouse.getDimension(), "N/A", mouse.getColor(), "N/A", "N/A", (Integer.toString(mouse.getPrice())), (Integer.toString(mouse.getQuantity()))};

            case "Monitor":
                DefaultMonitor monitor = (DefaultMonitor) computerComponent;
                return new String[]{monitor.getId(), monitor.getCategory(), monitor.getName(), monitor.getBrand(), "N/A", "N/A", "N/A", "N/A",
                        monitor.getDimension(), monitor.getResolution(), monitor.getColor(), "N/A", "N/A", (Integer.toString(monitor.getPrice())), (Integer.toString(monitor.getQuantity()))};

            case "Memory":
                DefaultMemory memory = (DefaultMemory) computerComponent;
                return new String[]{memory.getId(), memory.getCategory(), memory.getName(), memory.getBrand(), "N/A", "N/A", "N/A", "N/A",
                        "N/A", "N/A", "N/A", memory.getMemoryInterface(), memory.getSize(), (Integer.toString(memory.getPrice())), (Integer.toString(memory.getQuantity()))};

            case "Storage":
                DefaultStorage storage = (DefaultStorage) computerComponent;
                return new String[]{storage.getId(), storage.getCategory(), storage.getName(), storage.getBrand(), "N/A", "N/A", "N/A", "N/A",
                        "N/A", "N/A", "N/A", storage.getMemoryInterface(), storage.getSize(), (Integer.toString(storage.getPrice())), (Integer.toString(storage.getQuantity()))};

            case "CPU":
                DefaultCPU cpu = (DefaultCPU) computerComponent;
                return new String[]{cpu.getId(), cpu.getCategory(), cpu.getName(), cpu.getBrand(), cpu.getProductline(), cpu.getNumberOfCores(), cpu.getProcessorSpeed(), cpu.getGraphicClockSpeed(),
                        "N/A", "N/A", "N/A", "N/A", "N/A", (Integer.toString(cpu.getPrice())), (Integer.toString(cpu.getQuantity()))};

            case "GPU":
                DefaultGPU gpu = (DefaultGPU) computerComponent;
                return new String[]{gpu.getId(), gpu.getCategory(), gpu.getName(), gpu.getBrand(), gpu.getProductline(), gpu.getNumberOfCores(), gpu.getProcessorSpeed(), gpu.getGraphicClockSpeed(),
                        "N/A", "N/A", "N/A", "N/A", "N/A", (Integer.toString(gpu.getPrice())), (Integer.toString(gpu.getQuantity()))};

            default:
                throw new IllegalArgumentException("Category not matched: " + computerComponent.getCategory());
        }
    }

    public List<ComputerComponent> getAll() throws SQLException {
        try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM COMPUTER_COMPONENT");) {
            List<ComputerComponent> componentList = new ArrayList<>();
            try (ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    componentList.add(getComputerComponent(res));
                }
            }
            return componentList;

        }
    }

    private ComputerComponent getComputerComponent(ResultSet res) throws SQLException {

        return ComputerComponentFactory.newComponent(res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5),
                res.getString(6),
                res.getString(7),
                res.getString(8),
                res.getString(9),
                res.getString(10),
                res.getString(11),
                res.getString(12),
                res.getString(13),
                res.getString(14),
                res.getString(15));
    }
}

