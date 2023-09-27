package com.mystore.Utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class objects implements Serializable{

    private static final long serialVersionUID = 1L;
    public static List<objects> objectsList = new ArrayList<>();
    String product;//nombre del producto
    int inventoryNumber;//numero de inventario
    int invetoryQuantity;//cantidad en inventario
    double productPrice;//precio de producto

    objects(String product, int inventoryNumber, int invetoryQuantity, double productPrice){
        this.product = product;
        this.inventoryNumber = inventoryNumber;
        this.invetoryQuantity= invetoryQuantity;
        this.productPrice = productPrice;
    }
}