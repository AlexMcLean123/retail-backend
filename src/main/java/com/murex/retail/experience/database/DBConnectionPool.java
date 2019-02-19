package com.murex.retail.experience.database;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import javax.sql.DataSource;

public class DBConnectionPool {
    private static final String URL = "jdbc:h2:" + "./Database/myDB";
    private static final String USER = "root";
    private static final String PASS = "password";
    private GenericObjectPool connectionPool = null;

    public DataSource setUp() {
        connectionPool = new GenericObjectPool();
        connectionPool.setMaxActive(10);
        ConnectionFactory cf = new DriverManagerConnectionFactory(
                DBConnectionPool.URL,
                DBConnectionPool.USER,
                DBConnectionPool.PASS);
        new PoolableConnectionFactory(cf, connectionPool, null, null, false, true);
        return new PoolingDataSource(connectionPool);
    }

    public GenericObjectPool getConnectionPool() {
        return connectionPool;
    }
}
