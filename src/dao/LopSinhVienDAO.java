/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.LopSinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.SinhVien;
/**
 *
 * @author acer
 */
public class LopSinhVienDAO {
    List<LopSinhVien> ls = new ArrayList<>();
    Connection conn = null;
    PreparedStatement sttm = null;
    
    public int add(LopSinhVien l)
    {
        try {
            String sSQL = "insert into LopSinhVien(maLop, tenLop) values(?, ?)";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, l.getMaLop());
            sttm.setString(2, l.getTenLop());
           
            if(sttm.executeUpdate() > 0)
            {
                System.out.println("Them thanh cong");
                return 1;
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<LopSinhVien> getALlLopSV()
    {
        List<LopSinhVien> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from LopSinhVien";
            conn = database.DatabaseHelper.getDBConnect();
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                LopSinhVien l = new LopSinhVien();
                l.setMaLop(rs.getString(1));
                l.setTenLop(rs.getString(2));
                ls.add(l);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        finally{
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return ls;
    }
 
    
    public int delLopSinhVienByID(String maLop)
    {
        try {
            String sSQL = "delete LopSinhVien where maLop = ?";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maLop);
            
            
            if(sttm.executeUpdate() > 0)
            {
                System.out.println("Xoa thanh cong");
                return 1;
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public LopSinhVien getLopSinhVienByID(String maLop)
    {
        ResultSet rs = null;
        LopSinhVien l = new LopSinhVien();
        try {
            String sSQL = "select * from LopSinhVien where maLop =?";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maLop);
            rs = sttm.executeQuery();
            while (rs.next()) {
                l.setMaLop(rs.getString(1));
                l.setTenLop(rs.getString(2));
                return l;
            }
        } catch (Exception e) {
            System.out.println("Err: " + e.toString());
        }
        finally{
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    public int updateSinhVienByID(LopSinhVien l, String maLop)    {
        try {
            String sSQL = "update LopSinhVien set maLop = ?, tenLop = ? where maLop=?";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(2, l.getTenLop());
            sttm.setString(1, l.getMaLop());
            sttm.setString(3,maLop);
            if(sttm.executeUpdate() > 0)
            {
                System.out.println("Sua thanh cong");
                return 1;
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<SinhVien> getALlSinhVienByMaLop(String maLop)
    {
        List<SinhVien> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from SinhVien where MaLop='"+maLop+"'";
            conn = database.DatabaseHelper.getDBConnect();            
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString("MaSV"));
                sv.setTenSV(rs.getString("TenSV"));
                sv.setNgaySinh(rs.getDate("NgaySinh"));
                sv.setSdt(rs.getString("SDT"));
                sv.setDiaChi(rs.getString("DiaChi"));
                ls.add(sv);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        finally{
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return ls;
    }
    
}
