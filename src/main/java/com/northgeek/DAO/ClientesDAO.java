package com.northgeek.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.northgeek.DTO.ClientesDTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientesDAO {

    public void addCliente(Connection cn, int codigo, String nombre, String apellido, String cedula, String celular) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement st = cn.createStatement();
        String sql = "INSERT INTO clientes(codigo,nombre,apellido,cedula,celular) VALUES(?,?,?,?,?)";
        String use = "use NorthGeek";
        try {
            st.execute(use);
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo); 
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, cedula);
            ps.setString(5, celular);
            int columnas = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "CLIENTE INGRESADO CORRECTAMENTE");
            while (rs != null) {
                ClientesDTO clientes = new ClientesDTO();
                clientes.setCodigo(rs.getInt(1));
                clientes.setNombre(rs.getString("nombre"));
                clientes.setApellido(rs.getString("apellido"));
                clientes.setCedula(rs.getString("cedula"));
                clientes.setCelular(rs.getString("celular"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL INGRESAR CLIENTE DAO"); //haceme un pete colorado
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

    public void eliminarClientes(Connection cn, int codigo) throws SQLException {
        PreparedStatement ps = null;
        Statement base = cn.createStatement();
        String dbsql = "use NorthGeek";
        ResultSet rs = null;
        String sql = "delete from clientes where codigo=?";
        try {
            base.execute(dbsql);
            ps = cn.prepareCall(sql);
            ps.setInt(1, codigo);
            int columna = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "SE HA ELIMINADO CORRECTAMENTE UN CLIENTE");
            while (rs != null) {
                ClientesDTO clientes = new ClientesDTO();
                clientes.setCodigo(rs.getInt("codigo"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "FALLO AL ELIMINAR CLIENTE");
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

    }
    
    public ClientesDTO listarClientes(Connection cn, String cedula) throws SQLException {
        PreparedStatement ps = null;
        String query = "select * from clientes where cedula = ?";
        Statement st = cn.createStatement();
        String dbsql = "use NorthGeek";
        ResultSet rs = null;
        ClientesDTO cli = null;
        try {
            st.execute(dbsql);
            ps = cn.prepareStatement(query);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            while(rs.next()){
                cli = new ClientesDTO();
                cli.setCedula(rs.getString("cedula"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setCelular(rs.getString("celular"));
                cli.setCodigo(rs.getInt("codigo"));
                JOptionPane.showMessageDialog(null, "SE HA ENCONTRADO CLIENTE");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE HA ENCONTRADO CLIENTE");
            ex.printStackTrace();
        } finally{
            if(ps!= null){
                ps.close();
            } if(rs != null){
                rs.close();
            }
        }
        return cli;
    }
}

