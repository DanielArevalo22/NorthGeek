
package com.northgeek.bo;

import com.northgeek.DAO.MerchDAO;
import com.northgeek.DTO.MerchDTO;
import com.northgeek.db.ConnectionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MerchBO {
    MerchDAO merchDAO = new MerchDAO();
    ConnectionDB conn = new ConnectionDB();
    Connection cn;
    
    public void addProduct(int codigo, String marca, String producto, double precio, String categoria, int stock) throws SQLException{
        try {
            cn = conn.conexion();
            merchDAO.addProd(cn, codigo, marca, marca, precio, categoria, stock);
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR DESDE CLASE BO");
            ex.printStackTrace();
        }finally{
            conn.closeConexion();
            System.out.println("CONEXION FINALIZADA BO");
        }
    }
    
    public ArrayList<MerchDTO> autocompletar(String categoria) throws ClassNotFoundException{
        cn = conn.conexion();
        try {
            return merchDAO.buscarProducto(cn, categoria);
        } catch (SQLException ex) {
            System.out.println("ERROR DESDE CLASE BO");
            ex.printStackTrace();
        }
        return null;
    }
}