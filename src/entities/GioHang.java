/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


public class GioHang {
    
    String mahoatuoi;
    String tenhoatuoi;
    int soluong;
    int TongTien;
    int dongia;

    public GioHang() {
    }

    public GioHang(String mahoatuoi, String tenhoatuoi, int soluong, int TongTien, int dongia) {
        this.mahoatuoi = mahoatuoi;
        this.tenhoatuoi = tenhoatuoi;
        this.soluong = soluong;
        this.TongTien = TongTien;
        this.dongia = dongia;
    }

    
    
    

    public GioHang(String tenhoatuoi, int soluong, int dongia) {
        this.tenhoatuoi = tenhoatuoi;
        this.soluong = soluong;
        this.dongia = dongia;
    }
    
    public String getMahoatuoi() {
        return mahoatuoi;
    }

    public void setMahoatuoi(String mahoatuoi) {
        this.mahoatuoi = mahoatuoi;
    }

    public String getTenhoatuoi() {
        return tenhoatuoi;
    }

    public void setTenhoatuoi(String tenhoatuoi) {
        this.tenhoatuoi = tenhoatuoi;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
    
    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
    
    public void Xuat(String ttgiohang){
        ttgiohang = "Mã Hoa: "+mahoatuoi+"\t\t Tên Hoa: "+tenhoatuoi+"\t\t Số lượng: "+soluong+"\t\t Đơn Giá: "+dongia+"\t\t Tổng tiền: "+TongTien+"\n";
    }
    
}
