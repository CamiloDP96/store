package com.mystore.Utilities;

public class compra {
    String nombreProduct; //nombre de producto
    int codigo;//numero de inventario
    int invetoryQuantityCompra;//cantidad en inventario
    double productPriceCompra;//precio de producto

    // Constuctor
    public compra(String nombreProduct,int codigo, int invetoryQuantityCompra, double productPriceCompra){
        this.codigo = codigo;
        this.invetoryQuantityCompra = invetoryQuantityCompra;
        this.productPriceCompra = productPriceCompra;
    }

    // Getter
    public String getNombreProduct(){
        return nombreProduct;
    }
    public int getCodigo(){
        return codigo;
    }
    public int getInventoryQuantityCompra(){
        return invetoryQuantityCompra;
    }
    public double getProductPriceCompra(){
        return productPriceCompra;
    }

    // Setter
    public double setProductPriceCompra(double preciodeCompra){
        this.productPriceCompra = preciodeCompra;
        return productPriceCompra;
    }

}
