/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class MonHoc {
    private String maMon, tenMon;
    private int nhom, sltclt, sltcth, dem;

    public MonHoc(String maMon, String tenMon, int nhom, int sltclt, int sltcth) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.nhom = nhom;
        this.sltclt = sltclt;
        this.sltcth = sltcth;
    }

    public MonHoc() {
        super();
    }
    
    public MonHoc(String maMon,  int sltclt, int sltcth, int dem, String tenMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.sltclt = sltclt;
        this.sltcth = sltcth;
        this.dem = dem;
    }

    public MonHoc(String maMon) {
        this.maMon = maMon;
    }
    
    

    public int getDem() {
        return dem;
    }

    public void setDem(int dem) {
        this.dem = dem;
    }
    
    
    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getNhom() {
        return nhom;
    }

    public void setNhom(int nhom) {
        this.nhom = nhom;
    }
    
    public int getSltclt() {
        return sltclt;
    }

    public void setSltclt(int sltclt) {
        this.sltclt = sltclt;
    }

    public int getSltcth() {
        return sltcth;
    }

    public void setSltcth(int sltcth) {
        this.sltcth = sltcth;
    }
    
    
}
