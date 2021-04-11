/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Myconnection;
import entities.UserModel;
import entities.loginuser;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author DiemNgonTrai
 */
public class UserDAO {

    public UserDAO() {
    }
    
    public int TaoTaiKhoan(UserModel um){
        int kq = 0;
        Connection cn = new Myconnection().getConnect();
        try {
            PreparedStatement ps = cn.prepareStatement("insert into UserLogins values(?,?,?,?,?)");
            ps.setString(1, um.getUsername());
            ps.setString(2, um.getPassword());
            ps.setInt(3, 1);
            ps.setInt(4, um.getManv());
            ps.setString(5, um.getMabaove());
            
            kq = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }
    
    public void FillCBbox(JComboBox cbo) {
        try {
            Connection cn = new Myconnection().getConnect();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select MaNV from NhanVien");
            while (rs.next()) {
                cbo.addItem(rs.getString(1));
            }
            cbo.setSelectedIndex(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void ShowTenNV(JComboBox cbo, JLabel lbl) {
        try {
            String MaNVien = cbo.getSelectedItem().toString();
            Connection cn = new Myconnection().getConnect();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select TenNhanVien from NhanVien where MaNV=" + MaNVien);
            if (rs.next()) {
                lbl.setText(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
