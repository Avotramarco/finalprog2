package com.gestion.concour.BaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@org.springframework.context.annotation.Configuration
public class Connections {
    private final String url;
    private final String user;
    private final String password;


    public Connections() {
        this.url = "jdbc:postgresql://localhost:5432/note";
        this.user = "postgres";
        this.password = "avotra jr";
    }

    public Connection createConnection() {
        try {
            return DriverManager.getConnection(
                    this.url, this.user, this.password
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection connection;
    public static void getConnection() {
        Connections base = new Connections();
        connection = base.createConnection();
    }

}
