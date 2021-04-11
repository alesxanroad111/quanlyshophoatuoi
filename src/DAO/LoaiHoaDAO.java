/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Myconnection;
import entities.LoaiHoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class LoaiHoaDAO {

        public void showDetail(JTable tbl) {
        String header[] = {"Mã Loại Hoa", "Tên Loại Hoa"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new Myconnection().getConnect();
            Statement st = con.createStatement();
            String sql = " select * from LoaiHoa";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public LoaiHoa hienthi(JTable tbl) {
        String MaLoaiHoa = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0));
        String TenLoaiHoa = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 1));
        LoaiHoa lh = new LoaiHoa(MaLoaiHoa, TenLoaiHoa);
        return lh;
    }
    public void them(LoaiHoa lh){
        try {
            Connection con = new Myconnection().getConnect();
            String sql = ("insert into LoaiHoa values (?,?)");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lh.getMaLoaiHoa());
            ps.setString(2, lh.getTenLoaiHoa());
            ps.execute();
        } catch (Exception e) {
        }
    }
    public void sua(LoaiHoa lh){
     try{
        Connection con = new Myconnection().getConnect();
        String sql = ("Update LoaiHoa set TenLoaiHoa=?  where MaLoaiHoa=?");
        PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(2, lh .getMaLoaiHoa());
         ps.setString(1, lh .getTenLoaiHoa());
         ps.execute();
    } catch (Exception e ){
            e.printStackTrace();
            }
    }
    public void xoa(LoaiHoa lh){
       try{
        Connection con = new Myconnection().getConnect();
        String sql = ("Delete from LoaiHoa where MaLoaiHoa=? ");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, lh .getMaLoaiHoa());
        ps.execute();   
    } catch (Exception e ){
            e.printStackTrace();
            }
        
    }
}
