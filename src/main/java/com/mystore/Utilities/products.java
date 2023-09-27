package com.mystore.Utilities;

public class products {
    public static void addProduct() {
        //agregar objeto a BD
        System.out.println("add Product");
        String product;//nombre del producto
        int inventoryNumber;//numero de inventario
        int invetoryQuantity;//cantidad en inventario
        double productPrice;//precio de producto
        //Creacion de objeto
        product = "catfood";
        System.out.println("Por favor ingrese el id del producto a agregar");
        inventoryNumber=45444823;
        invetoryQuantity = 777888;
        productPrice = 789543.99;
        //Uso de las variables en impresion
        System.out.println("producto | cantidad | codigo de registro | cantidad en inventario| precio");
        System.out.println(product + " | "  + inventoryNumber + " | " + invetoryQuantity + " | " + productPrice);
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
}

