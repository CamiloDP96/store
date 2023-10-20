package com.mystore.Utilities;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


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
        System.out.println("remover producto");
        return;
    }
    public static void updateProduct(){ //no completado
        //actualizar objeto a BD
        System.out.println("actualizar producto");
        return;
    }
    public static void printInventory (List<objects> productsList, Scanner sc){
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Utilities\\inventory.txt";
        List<objects> objectsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String producString = parts[0].toString();
                int codeNumber = Integer.parseInt(parts[1].trim());
                int inventory = Integer.parseInt(parts[2].trim());
                double price = Double.parseDouble(parts[3].trim());

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

        int inventoryNumberSearched = sc.nextInt();
        for (objects objects : productsList) {
            if(objects.getInventoryNumber() == inventoryNumberSearched){
                System.out.println("Producto{" + objects.getProduct() + ", codigo " + objects.getInventoryNumber() + ", cantidad en inventario" + objects.getInventoryQuantity() + ", precio " + objects.getProductPrice() + "}");
            }
        }
    }
    public static void purchase(List<objects> productsList, Scanner sc) {
        // Variable declaration
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Utilities\\inventory.txt";
        String nombreProducto = "";
        double precio = 0;
        double total = 0;
        int cantidadComprada = 0;
        int codigo = 10000000;
        List<objects> objectsList = new ArrayList<>();
        List<compra> compraList= new ArrayList<>();

        // Read inventory
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String producString = parts[0].toString();
                int codeNumber = Integer.parseInt(parts[1].trim());
                int inventory = Integer.parseInt(parts[2].trim());
                double price = Double.parseDouble(parts[3].trim());

                objects objects = new objects(producString, codeNumber, inventory, price);
                objectsList.add(objects);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ingrese los codigos de los productos");

        // purchase method
        do {
            codigo = sc.nextInt();
            for (objects objects: objectsList) {
                if (objects.getInventoryNumber()==codigo) {
                    precio = objects.getProductPrice();
                    nombreProducto = objects.getProduct();
                    cantidadComprada = 1;
                    objects.setInventoryQuantity(cantidadComprada);
                }
            }
            compra compra = new compra(nombreProducto, codigo, cantidadComprada, precio);
            compraList.add(compra);
            total = total + precio;
            cantidadComprada = 0;
            precio = 0;
        } while (codigo > 0);

        for (compra compra : compraList) {
            System.out.println(compra.getNombreProduct() + " " + compra.getCodigo() + " " + compra.getInventoryQuantityCompra() + " " + compra.getProductPriceCompra());
        }
        System.out.println("total a pagar: " + total);
    }
    /*public static void createinventory(){
        objects.runList();
    }*/
}