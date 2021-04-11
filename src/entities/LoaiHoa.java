/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


public class LoaiHoa {
    private String MaLoaiHoa;
    private String TenLoaiHoa;

    public LoaiHoa() {
    }

    public LoaiHoa(String MaLoaiHoa, String TenLoaiHoa) {
        this.MaLoaiHoa = MaLoaiHoa;
        this.TenLoaiHoa = TenLoaiHoa;
    }

    public String getMaLoaiHoa() {
        return MaLoaiHoa;
    }

    public void setMaLoaiHoa(String MaLoaiHoa) {
        this.MaLoaiHoa = MaLoaiHoa;
    }

    public String getTenLoaiHoa() {
        return TenLoaiHoa;
    }

    public void setTenLoaiHoa(String TenLoaiHoa) {
        this.TenLoaiHoa = TenLoaiHoa;
    }
    
    
}
