package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static HikariDataSource dataSource;
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/bookstore");
        config.setUsername("root");
        config.setPassword("Student123!");
        dataSource = new HikariDataSource(config);
    }
    ConnectionPool() {

    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
