package com.mystore.Utilities;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import com.mystore.Utilities.objects;


public class products {
    public static void addProduct(Scanner sc, List<objects> objectsList) {
        //agregar objeto a BD
        String newProduct;//nombre del nuevo producto
        int newInventoryNumber;//numernewI de inventario
        int newInvetoryQuantity;//cantidanewI en inventario
        double newProductPrice;//precio de nuevo producto
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Utilities";

        System.out.println("ingrese el nombre del nuevo producto");
        newProduct = sc.next();
        System.out.println("ingrese el numero o codigo del nuevo newProducto");
        newInventoryNumber = sc.nextInt();
        System.out.println("ingrese la cantidad a ingresar del nuevo producto");
        newInvetoryQuantity = sc.nextInt();
        System.out.println("ingrese el precio de venta del nuevo producto");
        newProductPrice = sc.nextInt();
        //List<objects> objectsList = new ArrayList<>();

        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            for (objects objectsList : products) {
                writer.println(products);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return;
    }

    public static void removeProduct(){
        //remover objeto a BD
        System.out.println("add Product");
        String product;//nombre del producto
        int inventoryNumber;//numero de inventario
        int invetoryQuantity;//cantidad en inventario
        double productPrice;//precio de producto
        //Creacion de objeto
        product = "catfood";
        System.out.println("Por favor ingrese el id del producto a remover");
        inventoryNumber=45444823;
        invetoryQuantity = 777888;
        productPrice = 789543.99;
        //Uso de las variables en impresion
        System.out.println("producto | cantidad | codigo de registro | cantidad en inventario| precio");
        System.out.println(product + " | "  + inventoryNumber + " | " + invetoryQuantity + " | " + productPrice);
        return;
    }
    public static void updateProduct(){
        //actualizar objeto a BD
        System.out.println("add Product");
        String product;//nombre del producto
        int inventoryNumber;//numero de inventario
        int invetoryQuantity;//cantidad en inventario
        double productPrice;//precio de producto
        //Creacion de objeto
        product = "catfood";
        System.out.println("Por favor ingrese el id del producto a actualizar");
        inventoryNumber=45444823;
        invetoryQuantity = 777888;
        productPrice = 789543.99;
        //Uso de las variables en impresion
        System.out.println("producto | cantidad | codigo de registro | cantidad en inventario| precio");
        System.out.println(product + " | "  + inventoryNumber + " | " + invetoryQuantity + " | " + productPrice);
        return;
    }
    public static void printInventory(){
        System.out.println("inventario");
        //print inventory
    }
    /*public static void createinventory(){
        objects.runList();
    }*/
}

