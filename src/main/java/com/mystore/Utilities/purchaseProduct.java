package com.mystore.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mystore.Dao.inventoryRW;
import com.mystore.Objects.Product;
import com.mystore.Objects.compra;

public class purchaseProduct {
    public static void purchase(List<Product> productServiceList, Scanner sc) {
        // Variable declaration
        String nombreProducto = "";
        double precio = 0;
        double total = 0;
        double IVA1 = 0;
        int cantidadComprada = 0;
        int codigo = 10000000;
        List<Product> objectsList = new ArrayList<>();
        List<compra> compraList= new ArrayList<>();

        // Read inventory
        objectsList = inventoryRW.readInventory();

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
}
