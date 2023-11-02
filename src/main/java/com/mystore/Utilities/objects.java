package com.mystore.Utilities;

import java.io.Serializable;


public class objects implements Serializable{

    // Contructor
    private static final long serialVersionUID = 1L;
    public static objects Objects;
    String product;//nombre del producto
    int inventoryNumber;//numero de inventario
    int invetoryQuantity;//cantidad en inventario
    double productPrice;//precio de producto
    //public List<objects> objectsList = new ArrayList<>();
    //product, inventoryNumber, invetoryQuantity, productPrice
    public objects(String product, int inventoryNumber, int invetoryQuantity, double productPrice){
        this.product = product;
        this.inventoryNumber = inventoryNumber;
        this.invetoryQuantity= invetoryQuantity;
        this.productPrice = productPrice;
    }

    // Setter
    public int setInventoryQuantity(int purchaseQuantity){
        this.invetoryQuantity = invetoryQuantity - purchaseQuantity;
        return this.invetoryQuantity;
    }
    public double setProductPrice(double newProductPrice){
        this.productPrice = newProductPrice;
        return this.productPrice;
    }

    // Getter
    public String getProduct(){
        return product;
    }
    public int getInventoryNumber(){
        return inventoryNumber;
    }
    public int getInventoryQuantity(){
        return invetoryQuantity;
    }
    public double getProductPrice(){
        return productPrice;
    }
    @Override
    public String toString() {
        return product + " " + inventoryNumber + " " + invetoryQuantity + " " + productPrice;
    }
}