package com.mystore;

import java.util.Scanner;
import com.mystore.Objects.Users;
import com.mystore.Utilities.DisplayMenu;


/**
 * Mi tienda de barrio!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        int x = 0;
        Scanner sc = new Scanner(System.in);
        //boolean create = true;
        Users admin = new Users("admin", "admin123");
        System.out.println("ingrese usuaio y contraseña");
        do {
            String user1 = sc.next();
            String userpassword = sc.next();
            if (user1.equals(admin.getUsername()) && userpassword.equals(admin.getPassword()) ) {
                System.out.println("login completado");
                do {
                    x = DisplayMenu.displayMenuMethod(sc, x);
                } while (x < 7);
            } else{
                System.out.println("usuario o contraseña incorrectos");
            }
        } while (x < 7);
        /*if (create == true) {
            productService.createinventory();
        }*/
    }
}