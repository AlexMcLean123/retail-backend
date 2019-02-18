package com.murex.retail.experience.database;

import javax.sql.DataSource;
import java.sql.*;

public final class InputToSQL {
    private InputToSQL() {
    }



    public static PreparedStatement parseToSQL(String[] array) throws SQLException {
        String id = array[0];
        String category = array[1];
        String name = array[2];
        String brand = array[3];
        String productLine = array[4];
        String numberOfCores = array[5];
        String processorClockSpeed = array[6];
        String graphicClockSpeed = array[7];
        String dimension = array[8];
        String resolution = array[9];
        String color = array[10];
        String interfaceType = array[11];
        String size = (array[12]);
        int price = Integer.parseInt(array[13]);
        int quantity = Integer.parseInt(array[14]);

        DataSource dataSource = new DBConnectionPool().setUp();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO COMPUTER_COMPONENT(ID,CATEGORY, NAME,BRAND,PRODUCT_LINE," +
                     "NUMBER_OF_CORES,PROCESSOR_CLOCK_SPEED,GRAPHIC_CLOCK_SPEED, DIMENSION, RESOLUTION," +
                     "COLOR,INTERFACE,SIZE,PRICE,QUANTITY) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);")) {
            stmt.setString(1, id);
            stmt.setString(2, category);
            stmt.setString(3, name);
            stmt.setString(4, brand);
            stmt.setString(5, productLine);
            stmt.setString(6, numberOfCores);
            stmt.setString(7, processorClockSpeed);
            stmt.setString(8, graphicClockSpeed);
            stmt.setString(9, dimension);
            stmt.setString(10, resolution);
            stmt.setString(11, color);
            stmt.setString(12, interfaceType);
            stmt.setString(13, size);
            stmt.setInt(14, price);
            stmt.setInt(15, quantity);
            stmt.execute();
            return stmt;
        }
    }
}

