package com.murex.retail.experience;

import com.murex.retail.experience.database.DBConnectionPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TruncateTable {
    private TruncateTable() {

    }

    public static void truncate() throws SQLException {
        DataSource dataSource = new DBConnectionPool().setUp();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("TRUNCATE TABLE COMPUTER_COMPONENT")) {
            stmt.execute();
        }
    }
}
