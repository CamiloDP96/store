package com.mystore;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        String product;//nombre del producto
        short purchaseQuantity;// cantidad ordenada / dia , mes
        int inventoryNumber;//numero de inventario
        int invetoryQuantity;//cantidad en inventario
        double productPrice;//precio de producto

        //Creacion de objeto
        product = "catfood";
        System.out.println("Por favor ingrese la cantidad ordenada:");
        purchaseQuantity = sc.nextShort();
        inventoryNumber=45444823;
        invetoryQuantity = 777888;
        invetoryQuantity = invetoryQuantity - purchaseQuantity;
        productPrice = 789543.99;

        //Uso de las variables en impresion
        System.out.println("producto | cantidad | codigo de registro | cantidad en inventario| precio");
        System.out.println(product + " | " + purchaseQuantity + " | " + inventoryNumber + " | " + invetoryQuantity + " | " + productPrice);
        if(sc!=null){
            sc.close();
        }
    }
}
