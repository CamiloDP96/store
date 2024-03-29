package com.mystore.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mystore.Dao.inventoryRW;
import com.mystore.Objects.Product;
import com.mystore.Objects.ticket;

public class purchaseProduct {
    public static void purchase(List<Product> productServiceList, Scanner sc) {
        // Variable declaration
        String nameProduct = "";
        String descriptionP = "";
        double price = 0;
        double total = 0;
        double IVA1 = 0;
        int purchasedQuantity = 0;
        int code = 10000000;
        List<Product> objectsList = new ArrayList<>();
        List<ticket> shoopList= new ArrayList<>();

        // Read inventory
        objectsList = inventoryRW.readInventory();

        System.out.println("ingrese los codes de los productos");

        // purchase method
        do {
            code = sc.nextInt();
            for (Product Product: objectsList) {
                if (Product.getInventoryNumber()==code) {
                    price = Product.getProductPrice();
                    descriptionP = Product.getDescription();
                    nameProduct = Product.getProduct();
                    purchasedQuantity = 1;
                    Product.setInventoryQuantity(purchasedQuantity);
                }
            }
            ticket ticket = new ticket(nameProduct,descriptionP , code, purchasedQuantity, price);
            shoopList.add(ticket);
            double iva = price * 0.19;
            IVA1 = IVA1 + iva;
            total = total + price + iva;
            purchasedQuantity = 0;
            price = 0;
        } while (code > 0);

        datenHour.getDate();
        for (ticket ticket : shoopList) {
            System.out.println(ticket.getNombreProduct() + " " + ticket.getCode() + " " + ticket.getInventoryQuantityTicket() + " " + ticket.getProductPriceTicket());
        }
        System.out.println("IVA: " + IVA1);
        System.out.println("total a pagar: " + total);
    }
}
