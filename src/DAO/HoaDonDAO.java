/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Myconnection;
import entities.HoaDonModel;
import helper.DateHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DiemNgonTrai
 */
public class HoaDonDAO {

    public HoaDonDAO() {
    }

    public void tablechitiethoadon(JTable tbl) {
        String[] headers = {"Mã Nhân Viên", "Mã Khách Hàng", "Mã Hóa Đơn", "Tên Hoa", "Ngày Bán", "Số Lượng", "Tổng Tiền"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        Connection cn = new Myconnection().getConnect();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select HoaDon.MaNV, HoaDon.MaKhachHang, HoaDon.MaHoaDon, HoaTuoi.TenHoa,HoaDon.NgayBan, ChiTietHoaDon.SoLuong, ChiTietHoaDon.TongTien from ChiTietHoaDon inner join HoaTuoi on HoaTuoi.MaHoaTuoi = ChiTietHoaDon.MaHoaTuoi inner join HoaDon on HoaDon.MaHoaDon=ChiTietHoaDon.MaHoaDon");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
        }
    }

    public void filltohoadon(JTable tbl) {
        String[] headers = {"Mã Hóa Đơn", "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Bán", "Mã Khách Hàng", "Tổng Tiền"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        Connection cn = new Myconnection().getConnect();
        try {
            String sql = "select MaHoaDon, HoaDon.MaNV, NHANVIEN.TenNhanVien, NgayBan, MaKhachHang, TongTien from HoaDon join NHANVIEN on NHANVIEN.MaNV = HoaDon.MaNV";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getInt(2));
                row.add(rs.getString(3));
                row.add(DateHelper.toString(rs.getDate(4)));
                row.add(rs.getString(5));
                row.add(rs.getInt(6));

                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public HoaDonModel hienthi(JTable tbl) {
        String mahoadon = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0));
        int manv = Integer.parseInt(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 1)));
        String ngayban = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 3));
        String makh = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 4));
        int tongtien = Integer.parseInt(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 5)));
        HoaDonModel hdm = new HoaDonModel(mahoadon, manv, ngayban, makh, tongtien);
        return hdm;
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

    public void filltocbo(JComboBox cbo) {
        try {
            Connection cn = new Myconnection().getConnect();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select MaNV from NhanVien");
            while (rs.next()) {
                cbo.addItem(rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int DeleteHoaDon(HoaDonModel hd) {
        int kq = 0;
        Connection cn = new Myconnection().getConnect();
        try {
            PreparedStatement ps = cn.prepareStatement("delete from ChiTietHoaDon where MaHoaDon=?");
            ps.setString(1, hd.getMaHoaDon());

            kq = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            PreparedStatement ps2 = cn.prepareStatement("delete from HoaDon where MaHoaDon=?");
            ps2.setString(1, hd.getMaHoaDon());
            kq = ps2.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }
    
    public int UpdateHD(HoaDonModel hd){
        int kq = 0;
        Connection cn = new Myconnection().getConnect();
        try {
            PreparedStatement ps = cn.prepareStatement("update HoaDon set MaNV=? where MaHoaDon=?");
            ps.setInt(1, hd.getMaNhanVien());
            ps.setString(2, hd.getMaHoaDon());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }

}
