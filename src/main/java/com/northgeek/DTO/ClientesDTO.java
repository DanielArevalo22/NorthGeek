package com.northgeek.DTO;

public class ClientesDTO {

    private int codigo;
    private String nombre;
    private String apellido;
    private String cedula;
    private String celular;

    public ClientesDTO() {
    }

    public ClientesDTO(int codigo, String nombre, String apellido, String cedula, String celular) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.celular = celular;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    

    @Override
    public String toString() {
        return "ClientesDTO{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", celular=" + celular + '}';
    }

}
