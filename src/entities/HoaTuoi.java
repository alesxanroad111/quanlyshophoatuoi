/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


public class HoaTuoi {
    private String MaHoaTuoi;
    private String TenHoaTuoi;
    private String MaLoaiHoa;
    private int SoLuong;
    private int DonGia;
    private String Hinh;
    private String GhiChu;

    public HoaTuoi() {
    }

    public HoaTuoi(String MaHoaTuoi, String TenHoaTuoi, String MaLoaiHoa, int SoLuong, int DonGia, String Hinh, String GhiChu) {
        this.MaHoaTuoi = MaHoaTuoi;
        this.TenHoaTuoi = TenHoaTuoi;
        this.MaLoaiHoa = MaLoaiHoa;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.Hinh = Hinh;
        this.GhiChu = GhiChu;
    }

    public String getMaHoaTuoi() {
        return MaHoaTuoi;
    }

    public void setMaHoaTuoi(String MaHoaTuoi) {
        this.MaHoaTuoi = MaHoaTuoi;
    }

    public String getTenHoaTuoi() {
        return TenHoaTuoi;
    }

    public void setTenHoaTuoi(String TenHoaTuoi) {
        this.TenHoaTuoi = TenHoaTuoi;
    }

    public String getMaLoaiHoa() {
        return MaLoaiHoa;
    }

    public void setMaLoaiHoa(String MaLoaiHoa) {
        this.MaLoaiHoa = MaLoaiHoa;
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

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
