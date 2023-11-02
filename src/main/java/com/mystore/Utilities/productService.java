package com.mystore.Utilities;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class productService {
    public static List<Product> addProduct(Scanner sc) {
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
        List<Product> productServiceList = new ArrayList<>();
        productServiceList.add(new Product(newProduct, newInventoryNumber, newInvetoryQuantity, newProductPrice));

        try(FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            for (Product Product : productServiceList) {
                out.println(Product + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productServiceList;
    }

    public static void removeProduct(Scanner sc){ //no completado
        //remover objeto a BD
        System.out.println("remover producto");
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Utilities\\inventory.txt";
        List<Product> objectsList = new ArrayList<>();
        int codigo = 0;

        //actualizar objeto a BD
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String producString = parts[0].toString();
                int codeNumber = Integer.parseInt(parts[1].trim());
                int inventory = Integer.parseInt(parts[2].trim());
                double price = Double.parseDouble(parts[3].trim());

                Product Product = new Product(producString, codeNumber, inventory, price);
                objectsList.add(Product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //buscar y borrar objeto
        System.out.println("ingrese el codigo del objeto a actualizar");
        codigo = sc.nextInt();
        for (Product Product: objectsList) {
            if (Product.getInventoryNumber()==codigo) {
                int index = objectsList.indexOf(Product);
                objectsList.remove(index);
            }
        }

        //overwrite inventory
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(""); // Overwrite the file with an empty string
            writer.close();
            System.out.println("Contents deleted successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        try(FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            for (Product Product : objectsList) {
                out.println(Product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    public static void updateProduct(Scanner sc){ //no completado
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Utilities\\inventory.txt";
        List<Product> objectsList = new ArrayList<>();
        int codigo = 0;

        //actualizar objeto a BD
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String producString = parts[0].toString();
                int codeNumber = Integer.parseInt(parts[1].trim());
                int inventory = Integer.parseInt(parts[2].trim());
                double price = Double.parseDouble(parts[3].trim());

                Product Product = new Product(producString, codeNumber, inventory, price);
                objectsList.add(Product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //actualizar objeto
        System.out.println("ingrese el codigo del objeto a actualizar");
        codigo = sc.nextInt();
        for (Product Product: objectsList) {
            if (Product.getInventoryNumber()==codigo) {
                double newPrice = sc.nextDouble();
                Product.setProductPrice(newPrice);
                int inQ = sc.nextInt();
                inQ = inQ * (-1);
                Product.setInventoryQuantity(inQ);
            }
        }


        //overwrite inventory
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(""); // Overwrite the file with an empty string
            writer.close();
            System.out.println("Contents deleted successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        try(FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            out.println(objectsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
    public static void printInventory (List<Product> productServiceList, Scanner sc){
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Utilities\\inventory.txt";
        List<Product> objectsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String producString = parts[0].toString();
                int codeNumber = Integer.parseInt(parts[1].trim());
                int inventory = Integer.parseInt(parts[2].trim());
                double price = Double.parseDouble(parts[3].trim());

                Product Product = new Product(producString, codeNumber, inventory, price);
                objectsList.add(Product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the list of Product Product
        for (Product Product : objectsList) {
            System.out.println(Product);
        }

        int inventoryNumberSearched = sc.nextInt();
        for (Product Product : productServiceList) {
            if(Product.getInventoryNumber() == inventoryNumberSearched){
                System.out.println("Producto{" + Product.getProduct() + ", codigo " + Product.getInventoryNumber() + ", cantidad en inventario" + Product.getInventoryQuantity() + ", precio " + Product.getProductPrice() + "}");
            }
        }
    }
    public static void purchase(List<Product> productServiceList, Scanner sc) {
        // Variable declaration
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Utilities\\inventory.txt";
        String nombreProducto = "";
        double precio = 0;
        double total = 0;
        double IVA1 = 0;
        int cantidadComprada = 0;
        int codigo = 10000000;
        List<Product> objectsList = new ArrayList<>();
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

                Product Product = new Product(producString, codeNumber, inventory, price);
                objectsList.add(Product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ingrese los codigos de los productos");

        // purchase method
        do {
            codigo = sc.nextInt();
            for (Product Product: objectsList) {
                if (Product.getInventoryNumber()==codigo) {
                    precio = Product.getProductPrice();
                    nombreProducto = Product.getProduct();
                    cantidadComprada = 1;
                    Product.setInventoryQuantity(cantidadComprada);
                }
            }
            compra compra = new compra(nombreProducto, codigo, cantidadComprada, precio);
            compraList.add(compra);
            double iva = precio * 0.19;
            IVA1 = IVA1 + iva;
            total = total + precio + iva;
            cantidadComprada = 0;
            precio = 0;
        } while (codigo > 0);

        datenHour.getDate();
        for (compra compra : compraList) {
            System.out.println(compra.getNombreProduct() + " " + compra.getCodigo() + " " + compra.getInventoryQuantityCompra() + " " + compra.getProductPriceCompra());
        }
        System.out.println("IVA: " + IVA1);
        System.out.println("total a pagar: " + total);
    }
    /*public static void createinventory(){
        Product.runList();
    }*/
}