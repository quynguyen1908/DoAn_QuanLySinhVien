/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author acer
 */
public class SinhVien {
    private String maSV;
    private String tenSV;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private LopSinhVien lopSV;  // sinh vien co ma lop tham chieu toi ma lop cua lop hoc
    private String namNhapHoc;
    private String hinhAnh;

    public SinhVien() {
    }

    public SinhVien(String maSV, String tenSV, boolean gioiTinh, String diaChi,Date ngaySinh, String sdt, LopSinhVien lopSV, String namNhapHoc, String hinhAnh) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.lopSV = lopSV;
        this.namNhapHoc = namNhapHoc;
        this.hinhAnh = hinhAnh;
    }

    public SinhVien(String maSV) {
        this.maSV = maSV;
    }
    
    

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public LopSinhVien getLopSV() {
        return lopSV;
    }

    public void setLopSV(LopSinhVien lopSV) {
        this.lopSV = lopSV;
    }

    public String getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(String namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    
}
