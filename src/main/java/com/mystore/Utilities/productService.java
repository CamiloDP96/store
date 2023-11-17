package com.mystore.Utilities;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import com.mystore.Dao.InventoryRW;
import com.mystore.Objects.Product;


public class ProductService {
    //añadir producto
    public static List<Product> addProduct(Scanner sc) {
        //agregar objeto a BD
        String newProduct;//nombre del nuevo producto
        int newInventoryNumber;//codigo del nuevo producto de inventario
        int newInvetoryQuantity;//cantidad del nuevo producto en inventario
        String newDescription;//descripcion del producto
        double newProductPrice;//precio de nuevo producto
        String newImageProduct;//url de la imagen de referencia del nuevo producto

        //ingreso de las variables por consola
        System.out.println("ingrese el nombre del nuevo producto");
        newProduct = sc.next();
        System.out.println("ingrese el numero o codigo del nuevo newProducto");
        newInventoryNumber = sc.nextInt();
        System.out.println("ingrese la cantidad a ingresar del nuevo producto");
        newInvetoryQuantity = sc.nextInt();
        System.out.println("ingrese la descripcion de empaque del nuevo producto");
        newDescription = sc.next();
        System.out.println("ingrese el precio de venta del nuevo producto");
        newProductPrice = sc.nextInt();
        System.out.println("si posee la url de imagen de referencia del nuevo producto copiela y peguela acontinuacion");
        newImageProduct = sc.next();
        List<Product> productServiceList = new ArrayList<>();
        productServiceList.add(new Product(newProduct, newInventoryNumber, newInvetoryQuantity, newDescription, newProductPrice, newImageProduct));

        InventoryRW.writeInventory(productServiceList);

        return productServiceList;
    }

    //Remover producto
    public static void removeProduct(Scanner sc){
        int codigo = 0; //codigo del producto a buscar

        List<Product> objectsList = InventoryRW.readInventory();

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
        InventoryRW.deleteInventory();

        InventoryRW.writeInventory(objectsList);

        return;
    }

    //actualizar producto
    public static void updateProduct(Scanner sc){
        List<Product> objectsList = new ArrayList<>();
        int codigo = 0;

        objectsList = InventoryRW.readInventory();

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
        InventoryRW.deleteInventory();

        InventoryRW.writeInventory(objectsList);

        return;
    }

    //imprimir inventario
    public static void printInventory (List<Product> productServiceList, Scanner sc){
        List<Product> objectsList = new ArrayList<>();

        objectsList = InventoryRW.readInventory();

        // imprimir el inventario de productos
        for (Product Product : objectsList) {
            System.out.println(Product);

        }

        /*
        int inventoryNumberSearched = sc.nextInt();
        for (Product Product : productServiceList) {
            if(Product.getInventoryNumber() == inventoryNumberSearched){
                System.out.println("Producto{" + Product.getProduct() + ", codigo " + Product.getInventoryNumber() + ", cantidad en inventario" + Product.getInventoryQuantity() + ", precio " + Product.getProductPrice() + "}");
            }
        }*/
    }

    public static void searchProduct(Scanner sc) {
        int code = 10000000;
        List<Product> objectsList = new ArrayList<>();
        objectsList = InventoryRW.readInventory();
        System.out.println("ingrese el codigo del producto a buscar");

        code = sc.nextInt();
            for (Product Product: objectsList) {
                if (Product.getInventoryNumber()==code) {
                    System.out.println(Product);
                }
            }
    }
}