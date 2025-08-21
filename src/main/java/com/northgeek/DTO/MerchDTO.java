package com.northgeek.DTO;

public class MerchDTO {

    private int codigo;
    private String producto;
    private String marca;
    private double precio;
    private String categoria;
    private int stock;

    public MerchDTO() {
    }

    public MerchDTO(int codigo, String producto, String marca, double precio, String categoria, int stock) {
        this.codigo = codigo;
        this.producto = producto;
        this.marca = marca;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "MerchDTO{" + "codigo=" + codigo + ", producto=" + producto + ", marca=" + marca + ", precio=" + precio + ", categoria=" + categoria + ", stock=" + stock + '}';
    }
}
