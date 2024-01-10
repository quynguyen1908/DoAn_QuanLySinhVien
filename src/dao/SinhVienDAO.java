/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.LopSinhVien;
import model.SinhVien;
/**
 *
 * @author acer
 */
public class SinhVienDAO {
    public static List<SinhVien> ls = new ArrayList<>();
    
    Connection conn = null;
    PreparedStatement sttm = null;
    
    SimpleDateFormat format_date = new SimpleDateFormat("yyyy/MM/dd");
    
    public int add(SinhVien sv)
    {
        try {
            String sSQL = "insert into SinhVien(maSV, tenSV, phai, ngaySinh, diaChi,sdt, maLop,namNhapHoc, hinhAnh)\n" +
                        "values(?, ?, ?, ?,?,?, ?,?, ?)";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, sv.getMaSV());
            sttm.setString(2, sv.getTenSV());
            sttm.setBoolean(3, sv.isGioiTinh());
            sttm.setString(4, format_date.format(sv.getNgaySinh()));
            sttm.setString(5, sv.getDiaChi());
            sttm.setString(6, sv.getSdt());
            sttm.setString(7, sv.getLopSV().getMaLop());
            sttm.setString(8, sv.getNamNhapHoc());
            sttm.setString(9, sv.getHinhAnh());
            
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
    
    public List<SinhVien> getAllSinhVien()
    {
        List<SinhVien> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from SinhVien";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setTenSV(rs.getString(2));
                sv.setGioiTinh(rs.getBoolean(3));
                sv.setNgaySinh(rs.getDate(4));
                sv.setDiaChi(rs.getString(5));
                sv.setSdt(rs.getString(6));
                sv.setLopSV(new LopSinhVien(rs.getString(7)));
                sv.setNamNhapHoc(rs.getString(8));
                sv.setHinhAnh(rs.getString(9));
                ls.add(sv);
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
        return ls;
    }
    
    
    public int delSinhVienByID(String maSV)
    {
        try {
            String sSQL = "delete SinhVien where maSV = ?";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            
            
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
    
    public SinhVien getSinhVienByID(String maSV)
    {
        ResultSet rs = null;
        SinhVien sv = new SinhVien();
        try {
            String sSQL = "select * from SinhVien where maSV =?";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            rs = sttm.executeQuery();
            while (rs.next()) {
                sv.setMaSV(rs.getString(1));
                sv.setTenSV(rs.getString(2));
                sv.setGioiTinh(rs.getBoolean(3));
                sv.setNgaySinh(rs.getDate(4));
                sv.setDiaChi(rs.getString(5));
                sv.setSdt(rs.getString(6));
                sv.setLopSV(new LopSinhVien(rs.getString(7)));
                sv.setNamNhapHoc(rs.getString(8));
                sv.setHinhAnh(rs.getString(9));
                return sv;
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
    
    public int updateSinhVienByID(SinhVien sv)    {
        try {
            String sSQL = "update SinhVien set tenSV = ?, phai = ?, ngaySinh = ?, diaChi = ?,sdt = ?, maLop = ?,namNhapHoc = ?, hinhAnh = ? where maSV = ?";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(9, sv.getMaSV());
            sttm.setString(1, sv.getTenSV());
            sttm.setString(3, format_date.format(sv.getNgaySinh()));
            sttm.setBoolean(2, sv.isGioiTinh());
            sttm.setString(4, sv.getDiaChi());
            sttm.setString(5, sv.getSdt());
            sttm.setString(6, sv.getLopSV().getMaLop());
            sttm.setString(7, sv.getNamNhapHoc());
            sttm.setString(8, sv.getHinhAnh());
            
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
    
}
