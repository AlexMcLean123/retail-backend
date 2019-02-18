package com.murex.retail.experience;


import com.murex.retail.experience.database.InputToSQL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public final class DatabaseInserter {
    private DatabaseInserter() {

    }

    static final Logger LOGGER = LogManager.getLogger(DatabaseInserter.class);

    public static void insertSQLIntoDatabase(List<String> componentList) throws SQLException {
        try {
            for (String x : componentList) {
                String[] componentValues = x.trim().split("\\s*,\\s*");
                InputToSQL.parseToSQL(componentValues);
            }
        } catch (Exception e) {
            throw new SQLException("Can't insert data into database", e);
        }
    }
}
