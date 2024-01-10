/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.LopTinChi;
import model.MonHoc;
/**
 *
 * @author acer
 */
public class LopTinChiDAO {
     public static final String connectionUrl = "jdbc:sqlserver://localhost;"
            + "databaseName= QLSV2;user=sa;password=123;encrypt=false";
    
     public static List<LopTinChi> selectAll() {
        Connection conn = null;
        try {
            conn = database.DatabaseHelper.getDBConnect();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("SELECT * FROM LOPTINCHI ltc");
            List<LopTinChi> ltcList = new ArrayList<>();
            MonHocDAO monHocDAO= new MonHocDAO();
            while (rs.next()) {
                LopTinChi ltc = new LopTinChi();
                ltc.setMaLopTC(rs.getInt("MaLopTC"));                
                ltc.setMh(monHocDAO.getMonHocByMaMon(rs.getString("MaMon").trim()));
                ltc.setNienKhoa(rs.getString("NienKhoa").trim());
                ltc.setHocKy(rs.getInt("HocKy"));
                ltc.setNhom(rs.getInt("Nhom"));
                ltc.setSlsvMin(rs.getInt("SlsvMin"));
                ltc.setSlsvMax(rs.getInt("SlsvMax"));
                ltcList.add(ltc);
            }
            return ltcList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
     
     public static List<LopTinChi> findAll() throws ClassNotFoundException {
        
        List<LopTinChi> list = new ArrayList<>();
        Connection conn = null;
        Statement statement = null; 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql = "select * from LopTinChi";
            statement = conn.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            List<LopTinChi> ltcList = new ArrayList<>();
            MonHocDAO monHocDAO= new MonHocDAO();
            while (rs.next()) {
//                LopTinChi x = new LopTinChi(resultSet.getString("nienKhoa"), 
//                        resultSet.getString("maMon"), resultSet.getInt("maLopTC"), resultSet.getInt("hocKy"),
//                        resultSet.getInt("nhom"),resultSet.getInt("slsvMin"),resultSet.getInt("slsvMax" ));
//                list.add(x);
                LopTinChi ltc = new LopTinChi();
                ltc.setMaLopTC(rs.getInt("MaLopTC"));                
                ltc.setMh(monHocDAO.getMonHocByMaMon(rs.getString("MaMon").trim()));
                ltc.setNienKhoa(rs.getString("NienKhoa").trim());
                ltc.setHocKy(rs.getInt("HocKy"));
                ltc.setNhom(rs.getInt("Nhom"));
                ltc.setSlsvMin(rs.getInt("SlsvMin"));
                ltc.setSlsvMax(rs.getInt("SlsvMax"));
                ltcList.add(ltc);
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(LopTinChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LopTinChiDAO.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
        return list;
    }
    public static void insert(LopTinChi x) throws ClassNotFoundException{
        Connection conn = null;
        
        PreparedStatement statement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql = "insert into LopTinChi (maMon,nienKhoa,hocKy,nhom,slsvMin,slsvMax) values   (?,?,?,?,?,?)";
            statement = conn.prepareCall(sql);
            
//            statement.setInt(1,x.getMaLopTC());
            statement.setString(1,x.getMh().getMaMon());
            statement.setString(2,x.getNienKhoa());
            statement.setInt(3,x.getHocKy());
            statement.setInt(4,x.getNhom());
            statement.setInt(5,x.getSlsvMin()); 
            statement.setInt(6,x.getSlsvMax());
            
            statement.execute();
                    
        } catch (SQLException ex) {
            Logger.getLogger(LopTinChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LopTinChiDAO.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
    }
    public static void update(LopTinChi x) throws ClassNotFoundException{
        Connection conn = null;       
        PreparedStatement statement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql = "update LopTinChi set maMon = ?,nienKhoa = ?,hocKy = ?,nhom = ?,slsvMin = ?,slsvMax = ? where maLopTC = ?";
            statement = conn.prepareCall(sql);
            
            statement.setInt(7,x.getMaLopTC());
            statement.setString(1,  x.getMh().getMaMon());
            statement.setString(2,x.getNienKhoa());
            statement.setInt(3,x.getHocKy());
            statement.setInt(4,x.getNhom());
            statement.setInt(5,x.getSlsvMin());
            statement.setInt(6,x.getSlsvMax());
            
            statement.execute();
                    
        } catch (SQLException ex) {
            Logger.getLogger(LopTinChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LopTinChiDAO.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
    }
    public static void delete(int maLopTC) throws ClassNotFoundException{
        Connection conn = null;       
        PreparedStatement statement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql = "delete from LopTinChi where maLopTC = ?";
            statement = conn.prepareCall(sql);        
            
            statement.setInt(1, maLopTC);
            
            statement.execute(); 
                    
        } catch (SQLException ex) {
            Logger.getLogger(LopTinChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LopTinChiDAO.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
    }
    public static List<LopTinChi> findByFullname(String maMon ) throws ClassNotFoundException {
        List<LopTinChi> list = new ArrayList<>();
        Connection conn = null;
        
        PreparedStatement statement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql = "select * from LopTinChi where maMon like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1,"%"+maMon+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                 LopTinChi x = new LopTinChi(resultSet.getString("nienKhoa"), new MonHoc(resultSet.getString("maMon").toString()), resultSet.getInt("maLopTC"), resultSet.getInt("hocKy"),resultSet.getInt("nhom"), 
                        resultSet.getInt("slsvMin"), resultSet.getInt("slsvMin"));
                list.add(x);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LopTinChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LopTinChiDAO.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
        return list;
    }
    
    Connection conn = null;
    PreparedStatement sttm = null;
    
    public LopTinChi getLTCByID(int maLopTC)
    {
        ResultSet rs = null;
        LopTinChi ltc = new LopTinChi();
        try {
            String sSQL = "select * from LopTinChi where maLopTC = ?";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, maLopTC);
            rs = sttm.executeQuery();
            while (rs.next()) {
                ltc.setMaLopTC(rs.getInt(1));
                ltc.setMh(new MonHoc(rs.getString(2)));
                ltc.setNienKhoa(rs.getString(3));
                ltc.setHocKy(rs.getInt(4));
                ltc.setNhom(rs.getInt(5));
                ltc.setSlsvMin(rs.getInt(6));
                ltc.setSlsvMax(rs.getInt(7));
                return ltc;
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
    public int getLTCByMaMonvaNhom(String maMon, int nhom)
    {
        ResultSet rs = null;
        int maLopTC = -1;
        try {
            String sSQL = "select LopTinChi.maLopTC from MonHoc, DangKiMon, LopTinChi "
                    + "where LopTinChi.maLopTC = DangKiMon.maLopTC and LopTinChi.maMon = MonHoc.maMon and LopTinChi.nhom = ? and LopTinChi.maMon = '" + maMon +"'";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, nhom);
//            sttm.setString(2, maMon);
            rs = sttm.executeQuery();
            while (rs.next()) {
                maLopTC = rs.getInt(1);
                return maLopTC;
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
        return -1;
    }
}
