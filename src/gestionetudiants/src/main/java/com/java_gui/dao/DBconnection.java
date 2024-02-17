package com.java_gui.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static Connection cnx;

    private DBconnection() throws SQLException {
        cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_swing", "root", "polytec24");
    }

    public static Connection getConnection() throws SQLException {
        if (cnx == null)
            new DBconnection();
        return cnx;
    }
}
