/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.SinhVien;
import model.tinhTrangDangKi;
/**
 *
 * @author acer
 */
public class tinhTrangDangKiDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    
    public int setTinhTrangDangKi(int bit)
    {
        try {
            String sSQL = "update TinhTrangDK set tt = ?";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, bit);
            
            
            if(sttm.executeUpdate() > 0)
            {
                System.out.println("Dang Ki");
                return 1;
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public tinhTrangDangKi getTinhTrang()
    {
        ResultSet rs = null;
        tinhTrangDangKi tt = new tinhTrangDangKi();
        try {
            String sSQL = "select tt from TinhTrangDK";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while (rs.next()) {
                tt.setTrangThai(rs.getBoolean(1));
                return tt;
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
}
