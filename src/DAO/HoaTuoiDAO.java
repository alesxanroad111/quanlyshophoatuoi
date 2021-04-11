/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Myconnection;
import entities.HoaTuoi;
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
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class HoaTuoiDAO {

    public void showDetail(JTable tbl) {
        String header[] = {"Mã Hoa Tươi", "Tên Hoa",
            "Mã Loại Hoa", "Số Lượng", "Đơin Giá", "Hình", "Ghi Chú"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new Myconnection().getConnect();
            Statement st = con.createStatement();
            String sql = " select * from HoaTuoi";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getInt(4));
                row.add(rs.getInt(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HoaTuoi hienthi(JTable tbl) {
        String MaHoaTuoi = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0));
        String TenHoaTuoi = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 1));
        String MaLoaiHoa = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 2));
        int SoLuong = Integer.parseInt(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 3)));
        int DonGia = Integer.parseInt(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 4)));
        String Hinh = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 5));
        String GhiChu = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 6));
        HoaTuoi lh = new HoaTuoi(MaHoaTuoi, TenHoaTuoi, MaLoaiHoa, SoLuong, DonGia, Hinh, GhiChu);
        return lh;
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
                ImageIO.write(img, "jpg", new File("src\\hoadathem\\" + str[str.length - 1]));
                Image dmg = img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(dmg);
                lbllogo.setIcon(icon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileimage;
    }

    public void them(HoaTuoi lh) {
        try {
            Connection con = new Myconnection().getConnect();
            String sql = ("insert into HoaTuoi values (?,?,?,?,?,?,?)");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lh.getMaHoaTuoi());
            ps.setString(2, lh.getTenHoaTuoi());
            ps.setString(3, lh.getMaLoaiHoa());
            ps.setInt(4, lh.getSoLuong());
            ps.setInt(5, lh.getDonGia());
            ps.setString(6, lh.getHinh());
            ps.setString(7, lh.getGhiChu());
            ps.execute();
        } catch (Exception e) {
        }
    }

    public int sua(HoaTuoi lh) {
        Connection cn = new Myconnection().getConnect();
        int kq = 0;
        if (cn == null) {
            return -1;
        }
        try {
            String sql = ("Update HoaTuoi set TenHoa=?, MaLoaiHoa=?, SoLuong=?, DonGia=?, Hinh=?, GhiChu=? where MaHoaTuoi=?");
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, lh.getTenHoaTuoi());
            ps.setString(2, lh.getMaLoaiHoa());
            ps.setInt(3, lh.getSoLuong());
            ps.setInt(4, lh.getDonGia());
            ps.setString(5, lh.getHinh());
            ps.setString(6, lh.getGhiChu());
            ps.setString(7, lh.getMaHoaTuoi());

            kq = ps.executeUpdate();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public void xoa(HoaTuoi lh) {
        try {
            Connection con = new Myconnection().getConnect();
            String sql = ("Delete from HoaTuoi where MaHoaTuoi=? ");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lh.getMaHoaTuoi());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void fillcbboxmaloaihoa(JComboBox cbmlh) {
        try {
            Connection cn = new Myconnection().getConnect();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select MaLoaiHoa from LoaiHoa");
            while (rs.next()) {
                cbmlh.addItem(rs.getString(1));
            }
            cbmlh.setSelectedIndex(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getMaCDByTen(String tenCD) {
        String maCD = null;

        try {
            Connection cn = new Myconnection().getConnect();

            PreparedStatement ps = cn.prepareStatement("SELECT MaHoaTuoi From HoaTuoi WHERE TenHoa = ? ");
            ps.setString(1, tenCD);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                maCD = rs.getString(1);
            }
        } catch (Exception e) {
        }

        return maCD;
    }

    public List<String> getTenHoa() {
        List<String> list = null;

        try {
            Connection cn = new Myconnection().getConnect();

            PreparedStatement ps = cn.prepareStatement("SELECT TenHoa FROM HoaTuoi");
            ResultSet rs = ps.executeQuery();

            list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString("TenHoa"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return list;
    }

    public List<HoaTuoi> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM HoaTuoi WHERE TenHoa LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    private List<HoaTuoi> select(String sql, Object... args) {
        List<HoaTuoi> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaTuoi model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private HoaTuoi readFromResultSet(ResultSet rs) throws SQLException {
        HoaTuoi model = new HoaTuoi();
        model.setMaHoaTuoi(rs.getString("MaHoaTuoi"));
        model.setTenHoaTuoi(rs.getString("TenHoa"));
        model.setMaLoaiHoa(rs.getString("MaLoaiHoa"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setDonGia(rs.getInt("DonGia"));
        model.setHinh(rs.getString("Hinh"));
        model.setGhiChu(rs.getString("GhiChu"));
        return model;
    }

    public void searchHoaTuoi(JTable tbl, String search) {
        String[] headers = {"Mã Hoa Tươi", "Tên Hoa",
            "Mã Loại Hoa", "Số Lượng", "Đơin Giá", "Hình", "Ghi Chú"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        Connection cn = new Myconnection().getConnect();
        if (search.equals("")) {
            try {
                String sql = "select * from HoaTuoi";
                PreparedStatement stm = cn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    Vector row = new Vector();
                    row.add(rs.getString(1));
                    row.add(rs.getString(2));
                    row.add(rs.getString(3));
                    row.add(rs.getInt(4));
                    row.add(rs.getInt(5));
                    row.add(rs.getString(6));
                    row.add(rs.getString(7));
                    model.addRow(row);
                }
                tbl.setModel(model);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                String sql = "select * from HoaTuoi";
                sql += " where MaHoaTuoi like '%" + search + "%' ";
                PreparedStatement stm = cn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    Vector row = new Vector();
                    row.add(rs.getString(1));
                    row.add(rs.getString(2));
                    row.add(rs.getString(3));
                    row.add(rs.getInt(4));
                    row.add(rs.getInt(5));
                    row.add(rs.getString(6));
                    row.add(rs.getString(7));
                    model.addRow(row);
                }
                tbl.setModel(model);
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                String sql = "select * from HoaTuoi";
                sql += " where TenHoa like '%" + search + "%' ";
                PreparedStatement stm = cn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    Vector row = new Vector();
                    row.add(rs.getString(1));
                    row.add(rs.getString(2));
                    row.add(rs.getString(3));
                    row.add(rs.getInt(4));
                    row.add(rs.getInt(5));
                    row.add(rs.getString(6));
                    row.add(rs.getString(7));
                    model.addRow(row);
                }
                tbl.setModel(model);
            } catch (Exception e) {
            }
            try {
                String sql = "select * from HoaTuoi";
                sql += " where MaLoaiHoa like '%" + search + "%' ";
                PreparedStatement stm = cn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    Vector row = new Vector();
                    row.add(rs.getString(1));
                    row.add(rs.getString(2));
                    row.add(rs.getString(3));
                    row.add(rs.getInt(4));
                    row.add(rs.getInt(5));
                    row.add(rs.getString(6));
                    row.add(rs.getString(7));
                    model.addRow(row);
                }
                tbl.setModel(model);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
