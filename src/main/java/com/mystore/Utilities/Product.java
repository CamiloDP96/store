package com.mystore.Utilities;

import java.io.Serializable;


public class Product implements Serializable{

    // Contructor
    private static final long serialVersionUID = 1L;
    public static Product Objects;
    String Product;//nombre del Producto
    int inventoryNumber;//numero de inventario
    int invetoryQuantity;//cantidad en inventario
    double ProductPrice;//precio de Producto
    public Product(String Product, int inventoryNumber, int invetoryQuantity, double ProductPrice){
        this.Product = Product;
        this.inventoryNumber = inventoryNumber;
        this.invetoryQuantity= invetoryQuantity;
        this.ProductPrice = ProductPrice;
    }

    // Setter
    public int setInventoryQuantity(int purchaseQuantity){
        this.invetoryQuantity = invetoryQuantity - purchaseQuantity;
        return this.invetoryQuantity;
    }
    public double setProductPrice(double newProductPrice){
        this.ProductPrice = newProductPrice;
        return this.ProductPrice;
    }

    // Getter
    public String getProduct(){
        return Product;
    }
    public int getInventoryNumber(){
        return inventoryNumber;
    }
    public int getInventoryQuantity(){
        return invetoryQuantity;
    }
    public double getProductPrice(){
        return ProductPrice;
    }
    @Override
    public String toString() {
        return Product + " " + inventoryNumber + " " + invetoryQuantity + " " + ProductPrice;
    }
}