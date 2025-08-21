
package com.northgeek.DTO;


public class FacturacionDTO{
    private String nombres;
    private String cedula;
    private String apellido;
    private String celular;

    public FacturacionDTO() {
    }

    public FacturacionDTO(String nombres, String cedula, String apellido, String celular) {
        this.nombres = nombres;
        this.cedula = cedula;
        this.apellido = apellido;
        this.celular = celular;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "FacturacionDTO{" + "nombres=" + nombres + ", cedula=" + cedula + ", apellido=" + apellido + ", celular=" + celular + '}';
    }
    
    
}
