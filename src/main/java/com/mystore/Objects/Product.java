package com.mystore.Objects;

import java.io.Serializable;


public class Product implements Serializable{

    // Contructor
    private static final long serialVersionUID = 1L;
    public static Product Objects;
    String Product;//nombre del Producto
    int inventoryNumber;//numero de inventario
    int invetoryQuantity;//cantidad en inventario
    String description;//descripcion del producto
    double ProductPrice;//precio de Producto
    String imageUrl;//imagen referencia de producto
    public Product(String Product, int inventoryNumber, int invetoryQuantity,String description, double ProductPrice, String imageUrl){
        this.Product = Product;
        this.inventoryNumber = inventoryNumber;
        this.invetoryQuantity= invetoryQuantity;
        this.description = description;
        this.ProductPrice = ProductPrice;
        this.imageUrl = imageUrl;
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
    public String getDescription() {
        return description;
    }
    public double getProductPrice(){
        return ProductPrice;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    @Override
    public String toString() {
        return inventoryNumber + ";" + Product + ";" + invetoryQuantity + ";" + description + ";" +";"+";" + ProductPrice;
    }
}