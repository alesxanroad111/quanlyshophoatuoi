/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author nguye
 */
public class loginuser {
    public static String username;
    public static String password;
    public static int vaitro;
    public static int manv;
    public static String mabaove;

    public loginuser() {
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        loginuser.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        loginuser.password = password;
    }

    public static int getVaitro() {
        return vaitro;
    }

    public static void setVaitro(int vaitro) {
        loginuser.vaitro = vaitro;
    }

    public static int getManv() {
        return manv;
    }

    public static void setManv(int manv) {
        loginuser.manv = manv;
    }

    public static String getMabaove() {
        return mabaove;
    }

    public static void setMabaove(String mabaove) {
        loginuser.mabaove = mabaove;
    }
    
    
    
}
