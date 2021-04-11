/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author DiemNgonTrai
 */
public class ChiTietHoaDon {
    String MaHoaDon;
    String MaHoaTuoi;
    int SoLuong, DonGia, TongTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String MaHoaDon, String MaHoaTuoi, int SoLuong, int DonGia, int TongTien) {
        this.MaHoaDon = MaHoaDon;
        this.MaHoaTuoi = MaHoaTuoi;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.TongTien = TongTien;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaHoaTuoi() {
        return MaHoaTuoi;
    }

    public void setMaHoaTuoi(String MaHoaTuoi) {
        this.MaHoaTuoi = MaHoaTuoi;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
    
           
}
