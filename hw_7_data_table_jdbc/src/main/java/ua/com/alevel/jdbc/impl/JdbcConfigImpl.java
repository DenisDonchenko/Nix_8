package ua.com.alevel.jdbc.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.jdbc.JdbcConfig;
import ua.com.alevel.jdbc.JdbcPropertyConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class JdbcConfigImpl implements JdbcConfig {

    private final JdbcPropertyConfig jdbcPropertyConfig;

    private Connection connection;
    private Statement statement;

    public JdbcConfigImpl(JdbcPropertyConfig jdbcPropertyConfig) {
        this.jdbcPropertyConfig = jdbcPropertyConfig;
    }

    @Override
    public void connect() {
        System.out.println("jpaPropertyConfig = " + jdbcPropertyConfig);
        try {
            Class.forName(jdbcPropertyConfig.getDriverClassName());
            connection = DriverManager.getConnection(
                    jdbcPropertyConfig.getUrl(),
                    jdbcPropertyConfig.getUsername(),
                    jdbcPropertyConfig.getPassword()
            );
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public Statement getStatement() {
        return statement;
    }
}
