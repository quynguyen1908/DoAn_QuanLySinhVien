/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class LopTinChi {
    private int maLopTC;
    private MonHoc mh; // vi ma mon lop tin chi tham chieu toi ma mon cua mon hoc
//    private String maMon;
    private String nienKhoa;
    private int hocKy;
    private int nhom;
    private int slsvMin, slsvMax;  // so luong sinh vien min, max

    public LopTinChi() {
    }

//    public LopTinChi(String nienKhoa, String maMon, int maLopTC, int hocKy, int nhom, int slsvMin, int slsvMax) {
//        this.nienKhoa = nienKhoa;
//        this.maMon = maMon;
//        this.maLopTC = maLopTC;
//        this.hocKy = hocKy;
//        this.nhom = nhom;
//        this.slsvMin = slsvMin;
//        this.slsvMax = slsvMax;
//    }
    
    public LopTinChi(String nienKhoa, MonHoc mh, int maLopTinChi, int hocKy, int nhom, int slsvMin, int slsvMax) {
        this.maLopTC = maLopTinChi;
        this.mh = mh;
        this.nienKhoa = nienKhoa;
        this.hocKy = hocKy;
        this.nhom = nhom;
        this.slsvMin = slsvMin;
        this.slsvMax = slsvMax;
    }


    public MonHoc getMh() {
        return mh;
    }

    public int getMaLopTC() {
        return maLopTC;
    }

    public void setMaLopTC(int maLopTC) {
        this.maLopTC = maLopTC;
    }

//    public String getMaMon() {
//        return maMon;
//    }
//
//    public void setMaMon(String maMon) {
//        this.maMon = maMon;
//    }

    
    
    public void setMh(MonHoc mh) {
        this.mh = mh;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public int getNhom() {
        return nhom;
    }

    public void setNhom(int nhom) {
        this.nhom = nhom;
    }

    public int getSlsvMin() {
        return slsvMin;
    }

    public void setSlsvMin(int slsvMin) {
        this.slsvMin = slsvMin;
    }

    public int getSlsvMax() {
        return slsvMax;
    }

    public void setSlsvMax(int slsvMax) {
        this.slsvMax = slsvMax;
    }

    
}
