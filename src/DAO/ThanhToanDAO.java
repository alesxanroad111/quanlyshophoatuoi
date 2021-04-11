/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Myconnection;
import entities.ChiTietHoaDon;
import entities.GioHang;
import entities.HoaDonModel;
import entities.KhachHang;
import javax.swing.JComboBox;
import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JLabel;

public class ThanhToanDAO {
    
    
    
    public ThanhToanDAO() {
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

    public static void TruyenTien(int tongtien) {
        try {
            Connection cn = new Myconnection().getConnect();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select sum(TongTien) from GioHang");
            if (rs.next()) {
                tongtien = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void TongGiaTien(JLabel lbl, int vnd) {
        try {
            Connection cn = new Myconnection().getConnect();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select sum(TongTien) from GioHang");
            if (rs.next()) {
                vnd = Integer.parseInt(rs.getString(1));
                Locale localeVN = new Locale("vi", "VN");
                NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                lbl.setText(currencyVN.format(vnd));
//                lbl.setText(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int ThanhToanHet(KhachHang kh, HoaDonModel hd, ChiTietHoaDon cthd) {
        int kq = 0;
        Connection cn = new Myconnection().getConnect();
        if(cn==null){
            return -1;
        }
        //insert khachhang
        try {
            PreparedStatement ps = cn.prepareStatement("insert into KhachHang values(?,?,?,?)");
            ps.setString(1, kh.getMaKhachHang());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getDiaChi());
            ps.setInt(4, kh.getDienThoai());

            kq = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        //insert HoaDon
        try {
            PreparedStatement ps = cn.prepareStatement("insert into HoaDon(MaHoaDon ,MaNV, MaKhachHang,TongTien) values(?,?,?,?)");
            ps.setString(1, hd.getMaHoaDon());
            ps.setInt(2, hd.getMaNhanVien());
            ps.setString(3, hd.getMaKH());
            ps.setInt(4, hd.getTongTien());
            
            kq = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        //insert chitiethoadon
        try {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from GioHang");
                while(rs.next()){
                    
                    PreparedStatement ps = cn.prepareStatement("insert into ChiTietHoaDon(MaHoaDon,MaHoaTuoi,SoLuong,DonGia,TongTien) values (?,?,?,?,?)");
                    ps.setString(1, cthd.getMaHoaDon());
                    ps.setString(2, rs.getString("MaHoaTuoi"));
                    ps.setInt(3, rs.getInt("SoLuong"));
                    ps.setInt(4, rs.getInt("DonGia"));
                    ps.setInt(5, rs.getInt("TongTien"));
                    
                    kq = ps.executeUpdate();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }
    public static void xuattthoadon(String mahoa[], String tenhoa[], int soluong[], int tongtien[], int dongia[]){
        Connection cn = new Myconnection().getConnect();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from GioHang");
            while (rs.next()){
                
            }
            for (int i = 0; i < rs.getRow(); i++) {
                mahoa[i] = rs.getString(1);
                tenhoa[i] = rs.getString(2);
                soluong[i] = rs.getInt(3);
                tongtien[i] = rs.getInt(4);
                dongia[i] = rs.getInt(5);
            }
        } catch (Exception e) {
        }
    }
}
