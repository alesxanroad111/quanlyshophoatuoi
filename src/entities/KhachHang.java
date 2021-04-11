/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Diem Ngon Trai
 */
public class KhachHang {
    private String MaKhachHang;
    private String TenKH;
    private String DiaChi;
    private int DienThoai;

    public KhachHang() {
    }

    public KhachHang(String MaKhachHang, String TenKH, String DiaChi, int DienThoai) {
        this.MaKhachHang = MaKhachHang;
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }
    
    
    
    

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(int DienThoai) {
        this.DienThoai = DienThoai;
    }
    
    
    
}

