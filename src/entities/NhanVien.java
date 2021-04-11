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
public class NhanVien {
    private int MaNV;
    private String TenNV;
    String ngaysinh2;
    private Date NgaySinh;
    private int GioiTinh;
    private String DiaChi;
    private String DienThoai;
    private String Hinh;
    int Luong;
    

    public NhanVien() {
    }

    public NhanVien(int MaNV, String TenNV, Date NgaySinh, int GioiTinh, String DiaChi, String DienThoai, String Hinh, int Luong) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.Hinh = Hinh;
        this.Luong = Luong;
    }

    public NhanVien(int MaNV, String TenNV, String ngaysinh2, int GioiTinh, String DiaChi, String DienThoai, String Hinh, int Luong) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.ngaysinh2 = ngaysinh2;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.Hinh = Hinh;
        this.Luong = Luong;
    }
    
    
    
    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    
    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getNgaysinh2() {
        return ngaysinh2;
    }

    public void setNgaysinh2(String ngaysinh2) {
        this.ngaysinh2 = ngaysinh2;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }
    
    
    
}
