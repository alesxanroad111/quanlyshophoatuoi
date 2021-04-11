/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Diem Ngon Trai
 */
public class HoaDonModel {
    private String MaHoaDon;
    private int MaNhanVien;
    private String tenNV;
    private Date NgayBan = helper.DateHelper.now();
    private String NgayBan2;
    private String MaKH;
    private int TongTien;

    public HoaDonModel() {
    }

    public HoaDonModel(String MaHoaDon, int MaNhanVien, String MaKH, int TongTien) {
        this.MaHoaDon = MaHoaDon;
        this.MaNhanVien = MaNhanVien;
        this.MaKH = MaKH;
        this.TongTien = TongTien;
    }

    public HoaDonModel(String MaHoaDon, int MaNhanVien, String NgayBan2, String MaKH, int TongTien) {
        this.MaHoaDon = MaHoaDon;
        this.MaNhanVien = MaNhanVien;
        this.NgayBan2 = NgayBan2;
        this.MaKH = MaKH;
        this.TongTien = TongTien;
    }
    
    

    public HoaDonModel(String MaHoaDon, String tenNV, String NgayBan2, String MaKH, int TongTien) {
        this.MaHoaDon = MaHoaDon;
        this.tenNV = tenNV;
        this.NgayBan2 = NgayBan2;
        this.MaKH = MaKH;
        this.TongTien = TongTien;
    }

    
    
    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getNgayBan2() {
        return NgayBan2;
    }

    public void setNgayBan2(String NgayBan2) {
        this.NgayBan2 = NgayBan2;
    }
    
    

    public Date getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(Date NgayBan) {
        this.NgayBan = NgayBan;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
    
}
