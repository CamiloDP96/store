package com.mystore.Objects;

public class ticket {
    String nameProduct; //nombre de producto
    String descriptionProduct; //descripcion del producto
    int code;//numero de inventario
    int invetoryQuantityCompra;//cantidad en inventario
    double productPriceCompra;//precio de producto

    // Constuctor
    public ticket(String nameProduct, String descriptionProduct, int code, int invetoryQuantityCompra, double productPriceCompra){
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.code = code;
        this.invetoryQuantityCompra = invetoryQuantityCompra;
        this.productPriceCompra = productPriceCompra;
    }

    // Getter
    public String getNombreProduct(){
        return nameProduct;
    }
    public String getDescriptionProduct() {
        return descriptionProduct;
    }
    public int getCode(){
        return code;
    }
    public int getInventoryQuantityTicket(){
        return invetoryQuantityCompra;
    }
    public double getProductPriceTicket(){
        return productPriceCompra;
    }

    // Setter
    public double setProductPriceTicket(double preciodeCompra){
        this.productPriceCompra = preciodeCompra;
        return productPriceCompra;
    }

}
