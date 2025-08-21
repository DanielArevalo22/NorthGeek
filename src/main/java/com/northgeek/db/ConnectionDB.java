package com.northgeek.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {

    Connection cn;
    private String URL = "jdbc:mysql://localhost:3306/?user=root";
    private String user = "root";
    private String password = "admin";
    private String sql = "select 1 from dual";

    public Connection conexion() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(URL, user, password);
            PreparedStatement ps = cn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    }

    public void closeConexion() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }
}
