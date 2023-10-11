package com.mystore.Utilities;
import java.util.LinkedList;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import com.mystore.Utilities.objects;
import java.util.Scanner;
import java.util.Collections;


public class products {
    public static List<objects> addProduct(Scanner sc) {
        //agregar objeto a BD
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Utilities\\inventory.txt";
        String newProduct;//nombre del nuevo producto
        int newInventoryNumber;//numernewI de inventario
        int newInvetoryQuantity;//cantidanewI en inventario
        double newProductPrice;//precio de nuevo producto

        System.out.println("ingrese el nombre del nuevo producto");
        newProduct = sc.next();
        System.out.println("ingrese el numero o codigo del nuevo newProducto");
        newInventoryNumber = sc.nextInt();
        System.out.println("ingrese la cantidad a ingresar del nuevo producto");
        newInvetoryQuantity = sc.nextInt();
        System.out.println("ingrese el precio de venta del nuevo producto");
        newProductPrice = sc.nextInt();
        List<objects> productsList = new ArrayList<>();
        productsList.add(new objects(newProduct, newInventoryNumber, newInvetoryQuantity, newProductPrice));

        try(FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            out.println(productsList);
        } catch (IOException e) {
        //exception handling left as an exercise for the reader newProduct + " " + newInventoryNumber + " " + newInvetoryQuantity + " " + newProductPrice
        }
        return productsList;
    }

    public static void removeProduct(){ //no completado
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
    public static void updateProduct(){ //no completado
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
    public static void printInventory (List<objects> productsList, Scanner sc){
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Utilities\\inventory.txt";
        List<objects> objectsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String producString = parts[0].trim();
                int codeNumber = Integer.parseInt(parts[1].trim());
                int inventory = Integer.parseInt(parts[2].trim());
                double price = Integer.parseInt(parts[3].trim());

                objects objects = new objects(producString, codeNumber, inventory, price);
                objectsList.add(objects);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the list of objects objects
        for (objects objects : objectsList) {
            System.out.println(objects);
        }

        System.out.println("por favor ingrese el id del producto a visualizar");

        int inventoryNumberSearched = sc.nextInt();
        for (objects objects : productsList) {
            if(objects.getInventoryNumber() == inventoryNumberSearched){
                System.out.println("Producto{" + objects.getProduct() + ", codigo " + objects.getInventoryNumber() + ", cantidad en inventario" + objects.getInventoryQuantity() + ", precio " + objects.getProductPrice() + "}");
            }
        }
    }
    /*public static void createinventory(){
        objects.runList();
    }*/
}

