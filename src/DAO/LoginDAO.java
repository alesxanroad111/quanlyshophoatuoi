/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Myconnection;
import UI.MainFrame;
import entities.loginuser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;

public class LoginDAO {

    public LoginDAO() {
    }
    
    public int login(loginuser lg){
        int kq = 0;
        Connection cn = new Myconnection().getConnect();
        if(cn==null){
            return -1;
        }
        try {
            PreparedStatement ps = cn.prepareStatement("select * from UserLogins where username=? and password=?");
            ps.setString(1, lg.getUsername());
            ps.setString(2, lg.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt("vaitro")==0){
                    return 1;
                }
                else if(rs.getInt("vaitro")==1){
                    return 2;
                }
                lg.setManv(rs.getInt("MaNV"));
            }
            else return 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }
    
    public void ten(JLabel lbl, loginuser u){
        lbl.setText(u.getUsername());
    }
    
    public static void tennhanvien(JLabel lbl, loginuser lg){
        Connection cn = new Myconnection().getConnect();
        try {
            try {
                PreparedStatement ps = cn.prepareStatement("select NHANVIEN.TenNhanVien from UserLogins join NHANVIEN on NHANVIEN.MaNV = UserLogins.MaNV where username=? and password=?");
                ps.setString(1, lg.getUsername());
                ps.setString(2, lg.getPassword());
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                   lbl.setText(rs.getString(1));
                }else{
                    lbl.setText(lg.getUsername());
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }
    
}
