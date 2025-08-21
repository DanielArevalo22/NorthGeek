package com.northgeek.DAO;

import com.northgeek.DTO.MerchDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MerchDAO {
    
    public void addProd(Connection cn, int codigo, String producto, String marca, double precio,String categoria, int stock) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement st = cn.createStatement();
        String database = "use NorthGeek";
        String sql = "INSERT INTO merch (codigo,producto,marca,precio,stock,categoria) values(?,?,?,?,?,?)";
        try {
            st.execute(database);
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, producto);
            ps.setString(3, marca);
            ps.setDouble(4, precio);
            ps.setString(5, categoria);
            ps.setInt(6, stock);
            int columnas = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "PRODUCTO REGISTRADO CON EXITO");
            while(rs != null){
                MerchDTO merch = new MerchDTO();
                merch.setCodigo(rs.getInt("codigo"));
                merch.setMarca(rs.getString("marca"));
                merch.setProducto(rs.getString("producto"));
                merch.setPrecio(rs.getDouble("precio"));
                merch.setCategoria(rs.getString("categoria"));
                merch.setPrecio(rs.getInt("codigo"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL INGRESAR MERCH // CLASE DAO");
            ex.printStackTrace();
        }finally{
            if(ps!= null){
                ps.close();
            } if(rs != null){
                rs.close();
            }
        }
    }
    
    public ArrayList<MerchDTO> buscarProducto(Connection cn, String categoria) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement st = cn.createStatement();
        String database = "use NorthGeek";
        ArrayList<MerchDTO> lista = new ArrayList<>();
        try {
            st.execute(database);
            ps = cn.prepareStatement("select * from merch where categoria = ?");
            ps.setString(1, categoria);
            rs = ps.executeQuery();
            while(rs.next()){
                MerchDTO merch = new MerchDTO();
                merch.setProducto(rs.getString("producto"));
                merch.setCodigo(rs.getInt("codigo"));
                merch.setMarca(rs.getString("marca"));
                merch.setPrecio(rs.getDouble("precio"));
                merch.setCategoria(rs.getString("categoria"));
                merch.setStock(rs.getInt("stock"));
                lista.add(merch);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR DESDE DAO");
            ex.printStackTrace();
        }finally{
            if(ps!= null){
                ps.close();
            } if (rs != null){
                rs.close();
            }
        }
        return lista;
    }
}
