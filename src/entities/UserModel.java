
package entities;


public class UserModel {
    
    private String username;
    private String password;
    private int vaitro;
    private int manv;
    private String mabaove;

    public UserModel() {
    }

    public UserModel(String username, String password, int vaitro, int manv, String mabaove) {
        this.username = username;
        this.password = password;
        this.vaitro = vaitro;
        this.manv = manv;
        this.mabaove = mabaove;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVaitro() {
        return vaitro;
    }

    public void setVaitro(int vaitro) {
        this.vaitro = vaitro;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getMabaove() {
        return mabaove;
    }

    public void setMabaove(String mabaove) {
        this.mabaove = mabaove;
    }

    
}
