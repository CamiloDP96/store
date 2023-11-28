package com.mystore.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.sun.tools.javac.Main;

public class SQLconnection {

    public static Connection connectBD(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/project-store", "user-store", "Abc123!");
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }

    public void disconnectBD(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}