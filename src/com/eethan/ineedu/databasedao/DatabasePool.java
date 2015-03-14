package com.eethan.ineedu.databasedao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DatabasePool{
	private static DatabasePool instance;
    private static ComboPooledDataSource dataSource;
 
    private DatabasePool() throws SQLException,PropertyVetoException {
        dataSource = new ComboPooledDataSource();
 
        dataSource.setUser("root");
        dataSource.setPassword("2014ineedu");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/ineedu");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setInitialPoolSize(20);
        dataSource.setMinPoolSize(50);
        dataSource.setMaxPoolSize(100);
        dataSource.setMaxStatements(150);
        dataSource.setAcquireIncrement(5);
        dataSource.setMaxIdleTime(60);
        dataSource.setIdleConnectionTestPeriod(60);
    }
 
    public static DatabasePool getInstance() {
        if (instance == null) {
            try {
                instance = new DatabasePool();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
 
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
