package com.murex.retail.experience.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class ReadData {
    private ReadData() {

    }

    private static final Logger logger = LogManager.getLogger(ReadData.class);

    public static List<String> readDataBase()throws SQLException{


        DBConnectionPool database = new DBConnectionPool();
        DataSource dataSource = database.setUp();
        List<String> componentList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();PreparedStatement stmt = conn.prepareStatement("SELECT * FROM COMPUTER_COMPONENT");) {

            try (ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    String data =
                            res.getString(1) + "," + res.getString(2) +
                                    "," + res.getString(3) + "," + res.getString(4) + "," +
                                    res.getString(5) + "," + res.getString(6) +
                                    "," + res.getString(7) + "," + res.getString(8) + "," +
                                    res.getString(9) + "," + res.getString(10) +
                                    "," + res.getString(11) + "," + res.getString(12) + "," +
                                    res.getString(13) + "," + res.getString(14) +
                                    "," + res.getString(15);
                    componentList.add(data);
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return componentList;
    }
}

