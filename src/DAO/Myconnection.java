/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Diem Ngon Trai
 */
public class Myconnection {
    
    public Myconnection() {
    }

    public Connection getConnect() {
        Connection cn = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyShopHoaTuoi";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(url, "sa", "ngocdiem");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
}
