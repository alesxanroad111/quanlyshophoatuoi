package DAO;

import DAO.Myconnection;
import UI.DoiMatKhauUI;
import entities.UserModel;
import entities.loginuser;
import java.sql.*;
import javax.swing.JOptionPane;

public class DoiMatKhauDAO {

    public DoiMatKhauDAO() {
    }

    public int Repass(UserModel um) {
        int kq = 0;
        Connection cn = new Myconnection().getConnect();
        if (cn == null) {
            return -1;
        } else {
            try {
                PreparedStatement ps = cn.prepareStatement("select MaBaoVe from UserLogins where username=?");
                ps.setString(1, um.getUsername());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    if (rs.getString(1).equals(um.getMabaove())) {
                        try {
                            PreparedStatement ps2 = cn.prepareStatement("update UserLogins set password=? where username=?");
                            ps2.setString(1, um.getPassword());
                            ps2.setString(2, um.getUsername());

                            kq = ps2.executeUpdate();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        return 3;
                    }
                }
            } catch (Exception e) {
                return 2;
            }
            return kq;
        }
    }

}
