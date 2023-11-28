package com.mystore;

import com.mystore.Objects.Users;
import com.mystore.Utilities.DisplayMenu;
import com.mystore.Utilities.SQLconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
    public static void main( String[] args )
    {
        int x = 0;
        Connection connection = null;
        Scanner sc = new Scanner(System.in);
        DriverManager.drivers().forEach(
                driver -> System.out.println(driver.toString())
        );
        connection = SQLconnection.connectBD();
        //boolean create = true;
        Users admin = new Users("admin", "admin123");
        System.out.println("ingrese usuaio y contraseña");
        do {
            String user1 = sc.next();
            String userpassword = sc.next();
            if (user1.equals(admin.getUsername()) && userpassword.equals(admin.getPassword()) ) {
                System.out.println("login completado");
                do {
                    x = DisplayMenu.displayMenuMethod(sc, x, connection);
                } while (x < 7);
            } else{
                System.out.println("usuario o contraseña incorrectos");
            }
        } while (x < 7);
    }
}
