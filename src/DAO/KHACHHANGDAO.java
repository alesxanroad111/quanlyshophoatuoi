package DAO;

import DAO.Myconnection;
import entities.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class KHACHHANGDAO {

    public int insert(KhachHang kh) {
        int kq = 0;
        Connection cn = new Myconnection().getConnect();
        if (cn == null) {
            return -1;
        }
        try {
            PreparedStatement ps = cn.prepareStatement("insert into KhachHang values(?,?,?,?)");
            ps.setString(1, kh.getMaKhachHang());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getDiaChi());
            ps.setInt(4, kh.getDienThoai());

            kq = ps.executeUpdate();
            ps.close();
            cn.close();
        } catch (Exception e) {
        }
        return kq;
    }

    public void showDetail(JTable tblKhachHang) {
        String[] headers = {"Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Điện Thoại"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        try {
            Connection cn = new Myconnection().getConnect();
            Statement st = cn.createStatement();
            String sql = "select * from KhachHang";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getInt(4));
                model.addRow(row);
            }
            tblKhachHang.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int deleteKhachHang(KhachHang KH) {
        int kq = 0;
        Connection cn = new Myconnection().getConnect();
        if (cn == null) {
            return -1;
        }
        try {
            PreparedStatement ps = cn.prepareStatement("delete from KhachHang where MaKhachHang=?");
            ps.setString(1, KH.getMaKhachHang());

            kq = ps.executeUpdate();
            ps.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }

    public int suaKhachHang(KhachHang kh) {
        int kq = 0;
        Connection cn = new Myconnection().getConnect();
        if (cn == null) {
            return -1;
        }
        try {
            PreparedStatement ps = cn.prepareStatement("update KhachHang set TenKH=?, DiaChi=?, DienThoai=? where MaKhachHang=?");
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getDiaChi());
            ps.setInt(3, kh.getDienThoai());
            ps.setString(4, kh.getMaKhachHang());
            kq = ps.executeUpdate();
            ps.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }

    public void searchKhachHang(JTable tblKhangHang, String search) {
        String[] headers = {"Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Điện Thoại"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        Connection cn = new Myconnection().getConnect();
        if (search.equals("")) {
            try {
                String sql = "select * from KhachHang";
                PreparedStatement stm = cn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    Vector row = new Vector();
                    row.add(rs.getString(1));
                    row.add(rs.getString(2));
                    row.add(rs.getString(3));
                    row.add(rs.getInt(4));
                    model.addRow(row);
                }
                tblKhangHang.setModel(model);
            } catch (Exception e) {
            }
        }
        else {
            try {
            String sql = "select * from KhachHang";
            sql += " where MaKhachHang like '%" + search + "%' ";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getInt(4));
                model.addRow(row);
            }
            tblKhangHang.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String sql = "select * from KhachHang";
            sql += " where TenKH like '%" + search + "%' ";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getInt(4));
                model.addRow(row);
            }
            tblKhangHang.setModel(model);
        } catch (Exception e) {
        }
        try {
            String sql = "select * from KhachHang";
            sql += " where DienThoai like '%" + search + "%' ";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getInt(4));
                model.addRow(row);
            }
            tblKhangHang.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
        }
    }
    
    public KhachHang hienhthi(JTable tbl){
        String makh = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0));
        String tenkh = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 1));
        String diachi = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 2));
        int dt = Integer.parseInt(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 3)));
        KhachHang kh = new KhachHang(makh, tenkh, diachi, dt);
        return kh;
    }
}
