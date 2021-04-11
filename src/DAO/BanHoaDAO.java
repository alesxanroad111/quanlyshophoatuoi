/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Myconnection;
import entities.GioHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BanHoaDAO {

    public BanHoaDAO() {
    }

    public int resettable() {
        int kq = 0;
        Connection cn = new Myconnection().getConnect();
        try {
            PreparedStatement ps = cn.prepareStatement("delete from GioHang");
            kq = ps.executeUpdate();
        } catch (Exception e) {
        }
        return kq;
    }

    public int BanHoa(GioHang gh) {
        int kq = 0;
        Connection cn = new Myconnection().getConnect();
        if (cn == null) {
            return -1;
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from GioHang where MaHoaTuoi='" + gh.getMahoatuoi() + "'");
            if (rs.next()) {
                if (gh.getMahoatuoi().equalsIgnoreCase(rs.getString(1))) {
                    try {
                        PreparedStatement ps = cn.prepareStatement("update GioHang set SoLuong=?, TongTien=? where MaHoaTuoi=?");
                        ps.setInt(1, gh.getSoluong() + rs.getInt(3));
                        ps.setInt(2, gh.getTongTien() + rs.getInt(4));
                        ps.setString(3, gh.getMahoatuoi());
                        kq = ps.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } 
            else {
                try {
                    PreparedStatement ps = cn.prepareStatement("insert into GioHang values(?,?,?,?,?)");
                    ps.setString(1, gh.getMahoatuoi());
                    ps.setString(2, gh.getTenhoatuoi());
                    ps.setInt(3, gh.getSoluong());
                    ps.setInt(4, gh.getTongTien());
                    ps.setInt(5, gh.getDongia());
                    kq = ps.executeUpdate();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }

    public void fillintable(JTable tbl) {
        String[] headers = {"Tên Hoa", "Số Lượng","Đơn Giá", "Thành Tiền"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        try {
            Connection cn = new Myconnection().getConnect();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select TenHoa, SoLuong, TongTien, DonGia from GioHang");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getInt(2));
                row.add(rs.getInt(4));
                row.add(rs.getInt(3));
                

                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public GioHang hienthi(JTable tbl) {
        String TenHoaTuoi = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0));
        int SoLuong = Integer.parseInt(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 1)));
        int DonGia = Integer.parseInt(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 2)));
        GioHang gh = new GioHang(TenHoaTuoi, SoLuong, DonGia);
        return gh;
    }
    
    public int deletehoa(String lbl){
        int kq =0;
        Connection cn = new Myconnection().getConnect();
        if(cn==null){
            return -1;
        }
        try {
            PreparedStatement ps = cn.prepareStatement("delete from GioHang where TenHoa=?");
            ps.setString(1, lbl);
            kq = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }
    
    
}
