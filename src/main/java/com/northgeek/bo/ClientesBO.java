package com.northgeek.bo;

import com.northgeek.DAO.ClientesDAO;
import com.northgeek.DTO.ClientesDTO;
import com.northgeek.db.ConnectionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesBO {

    ConnectionDB connection = new ConnectionDB();
    ClientesDAO cliente = new ClientesDAO();
    Connection cn;
    
    public void agregarCliente(int codigo, String nombre, String apellido, String cedula, String celular) throws SQLException {
        try {
            cn = connection.conexion();
            cliente.addCliente(cn, codigo, nombre, apellido, cedula, celular);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }finally{
            connection.closeConexion();
        }
    }
    
    
    public void eliminarCliente(int codigo) throws SQLException{
        try {
            cn = connection.conexion();
            cliente.eliminarClientes(cn, codigo);
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR ELIMINAR CLIENTE DESDE CLASE BO");
            ex.printStackTrace();
        }finally{
            connection.closeConexion();
        }
    }
    
    public ClientesDTO buscarCliente(String cedula) throws SQLException{
        try {
            cn = connection.conexion();
            return cliente.listarClientes(cn, cedula);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }finally{
            connection.closeConexion();
        }
        return null;
    }
}

