/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class DangKiMon {
    private int maLopTC;
    private String maSV;
    private float diem;

    public DangKiMon(int maLopTC, String maSV, float diem) {
        this.maLopTC = maLopTC;
        this.maSV = maSV;
        this.diem = diem;
    }

    public DangKiMon() {
        super();
    }

    public int getMaLopTC() {
        return maLopTC;
    }

    public void setMaLopTC(int maLopTC) {
        this.maLopTC = maLopTC;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
}
