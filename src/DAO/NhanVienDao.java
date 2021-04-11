/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Myconnection;
import entities.NhanVien;
import helper.DateHelper;
import helper.JdbcHelper;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class NhanVienDao {

    

    public int updateItem(NhanVien cd) {
        int kq = 0;
        Connection con = new Myconnection().getConnect();
        if (con == null) {
            return -1;
        }
        try {
            String sql = ("Update NhanVien set TenNhanVien=?, NgaySinh=?, GioiTinh=?, DiaChi=?, DienThoai=?, Hinh=?, Luong=? where MaNV=? ");
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cd.getTenNV());
            ps.setDate(2, new java.sql.Date(cd.getNgaySinh().getTime()));
            ps.setInt(3, cd.getGioiTinh());
            ps.setString(4, cd.getDiaChi());
            ps.setString(5, cd.getDienThoai());
            ps.setString(6, cd.getHinh());
            ps.setInt(7, cd.getLuong());
            ps.setInt(8, cd.getMaNV());
            kq = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }

    public int deleteItem(NhanVien cd) {
        int kq = 0;
        Connection con = new Myconnection().getConnect();
        if (con == null) {
            return -1;
        }
        try {
            String sql = ("Delete from NhanVien where MaNV=? ");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cd.getMaNV());

            kq = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }

    public int insertItem(NhanVien cd) {
        int kq = 0;
        Connection con = new Myconnection().getConnect();
        if (con == null) {
            return -1;
        }
        try {

            String sql = ("insert into NhanVien values (?,?,?,?,?,?,?)");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cd.getTenNV());
            ps.setDate(2, new java.sql.Date(cd.getNgaySinh().getTime()));
            ps.setInt(3, cd.getGioiTinh());
            ps.setString(4, cd.getDiaChi());
            ps.setString(5, cd.getDienThoai());
            ps.setString(6, cd.getHinh());
            ps.setInt(7, cd.getLuong());
            kq = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }

    public void showDetail(JTable tbl) {
        String header[] = {"Mã Nhân Viên", "Tên Nhân Viên",
            "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Điện Thoại", "Hình","Lương"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new Myconnection().getConnect();
            Statement st = con.createStatement();
            String sql = " select * from NhanVien";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getInt(1));
                row.add(rs.getString(2));
                row.add(DateHelper.toString(rs.getDate(3)));
                if(rs.getInt(4)==1){
                    row.add("Nữ");
                }
                else {
                    row.add("Nam");
                }
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                row.add(rs.getInt(8));
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NhanVien hienthi(JTable tbl) {
        int MaNV = Integer.parseInt(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0)));
        String TenNV = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 1));
        String NgaySinh2 = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 2));
        int GioiTinh;
        if(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 3)).equals("Nam")){
            GioiTinh = 0;
        }
        else {
            GioiTinh = 1;
        }
        String DiaChi = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 4));
        String DienThoai = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 5));
        String Hinh = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 6));
        int Luong = Integer.parseInt(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 7)));
        NhanVien cd = new NhanVien(MaNV, TenNV, NgaySinh2, GioiTinh, DiaChi, DienThoai, Hinh, Luong);
        return cd;
    }

    public String chonAnh(JLabel lbllogo) {
        String fileimage = "";
        BufferedImage img = null;
        JFileChooser filec = new JFileChooser();
        int r = filec.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            File fl = filec.getSelectedFile();
            try {
                img = ImageIO.read(fl);
                String qaz = String.valueOf(fl);
                String[] str = qaz.split("\\\\");
                fileimage = str[str.length - 1];
                JOptionPane.showMessageDialog(null, fileimage);
                ImageIO.write(img, "jpg", new File("src\\NhanVien\\" + str[str.length - 1]));
                Image dmg = img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(dmg);
                lbllogo.setIcon(icon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileimage;
    }
    public int resetluong(NhanVien cd) {
        int kq = 0;
        Connection con = new Myconnection().getConnect();
        
        try {
            String sql = ("Update NhanVien set Luong=0 where MaNV=?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cd.getMaNV());
            kq = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return kq;
    }
}
