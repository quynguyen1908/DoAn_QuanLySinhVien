/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DangKiMon;
import model.MonHoc;
import model.SinhVien;
/**
 *
 * @author acer
 */
public class DangKiMonDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    
    
public DangKiMon getSinhVienDangKiByID(String maSV)
    {
        ResultSet rs = null;
        DangKiMon dkm = new DangKiMon();
        try {
            String sSQL = "select * from DangKiMon where maSV =?";
            
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            rs = sttm.executeQuery();
            while (rs.next()) {
                dkm.setMaSV(rs.getString(1));
                dkm.setMaLopTC(rs.getInt(2));
                dkm.setDiem(rs.getFloat(3));
                return dkm;
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
    
    public static final String connectionUrl = "jdbc:sqlserver://localhost;"
            + "databaseName= QLSV2;user=sa;password=123;encrypt=false";
    public static List<DangKiMon> findAll() throws ClassNotFoundException {
        
        List<DangKiMon> list = new ArrayList<>();
        Connection conn = null;
        Statement statement = null; 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql = "select * from DangKiMon";
            statement = conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DangKiMon x = new DangKiMon(resultSet.getInt("maLopTC"), 
                        resultSet.getString("maSV"), resultSet.getFloat("diem"));
                list.add(x);
            }
                
        } catch (SQLException ex) {
//            Logger.getLogger(QLLTCModify.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERR: " + ex.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
//                    Logger.getLogger(QLLTCModify.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("ERR: " + ex.toString());
                }
            }
        }
        return list;
    }
    public List<DangKiMon> selectAll(int maLopTC) {
        Connection conn = null;
        try {
            conn = database.DatabaseHelper.getDBConnect();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("SELECT * FROM DANGKIMON dkm Where MaLopTC=" + maLopTC);
            List<DangKiMon> dkmList = new ArrayList<>();
            while (rs.next()) {
                DangKiMon dkm = new DangKiMon();                
                dkm.setMaLopTC(rs.getInt("MaLopTC"));
                dkm.setMaSV(rs.getString("MaSV").trim());
                dkm.setDiem(rs.getFloat("Diem"));                
                dkmList.add(dkm);
            }
            return dkmList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public int getLopTC(String maMon, int nhom) throws Exception {
        int maLopTC = 0;
        String sql = "select LopTinChi.maLopTC from LopTinChi, MonHoc where LopTinChi.maMon = MonHoc.maMon and MonHoc.maMon = ? and LopTinChi.nhom = ?";
        try (Connection con = database.DatabaseHelper.getDBConnect();  
            PreparedStatement pstm = con.prepareStatement(sql);) {
                
            pstm.setString(1, maMon);
            pstm.setInt(2, nhom);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                maLopTC = rs.getInt("maLopTC");
            }
            return maLopTC;
        }
    }
    public String getNienKhoaNewest() throws Exception {
        String nienKhoa = null;
        String sql = "select top(1) nienKhoa from LopTinChi order by nienKhoa desc";
        try (Connection con = database.DatabaseHelper.getDBConnect(); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            if (rs.next()) {
                nienKhoa = rs.getNString("nienKhoa");
            }
            return nienKhoa;
        }
    }
    // sửa sql
    public int getHocKyNewest() throws Exception {
        int hocKy = 0;
        String sql = "select top(1) hocKy from LopTinChi order by nienKhoa, hocKy desc";
        try (Connection con = database.DatabaseHelper.getDBConnect(); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            if (rs.next()) {
                hocKy = rs.getInt("hocKy");
            }
            return hocKy;
        }
    }
    // thêm hàm lấy lớp tín chỉ
    public List<MonHoc> getFillerLopTC() throws Exception {
        List<MonHoc> lstLopTCFiller = new ArrayList<>();
        String sql = "select MonHoc.maMon, MonHoc.tenMon, LopTinChi.nhom, MonHoc.sltclt, MonHoc.sltcth from LopTinChi, MonHoc, DangKiMon where LopTinChi.maLopTC = DangKiMon.maLopTC and LopTinChi.maMon = MonHoc.maMon "
                + "and MonHoc.maMon in (select maMon from LopTinChi where nienKhoa in (select top(1) nienKhoa from LopTinChi order by nienKhoa desc) and hocKy in (select top(1) hocKy from LopTinChi order by nienKhoa, hocKy desc)) "
                + "and (LopTinChi.maLopTC in (select maLopTC from DangKiMon group by maLopTC having count(*) < slsvMin) or LopTinChi.maLopTC not in (select LopTinChi.maLopTC from LopTinChi, DangKiMon where LopTinChi.maLopTC = DangKiMon.maLopTC and diem != -1)) "
                + "group by MonHoc.maMon, MonHoc.tenMon, LopTinChi.nhom, MonHoc.sltclt, MonHoc.sltcth";
        try (Connection con = database.DatabaseHelper.getDBConnect(); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMon(rs.getNString("maMon"));
                mh.setTenMon(rs.getNString("tenMon"));
                mh.setNhom(rs.getInt("nhom"));
                mh.setSltclt(rs.getInt("sltclt"));
                mh.setSltcth(rs.getInt("Sltcth"));
                lstLopTCFiller.add(mh);
            }
            return lstLopTCFiller;
        }
    }
    // sửa sql
    public List<MonHoc> getFillerMH() throws Exception {
        List<MonHoc> lstMHFiller = new ArrayList<>();
        String sql = "select MonHoc.maMon, MonHoc.tenMon, LopTinChi.nhom, MonHoc.sltclt, MonHoc.sltcth from LopTinChi, MonHoc where LopTinChi.maMon = MonHoc.maMon "
                + "and MonHoc.maMon in (select maMon from LopTinChi where nienKhoa in (select top(1) nienKhoa from LopTinChi order by nienKhoa desc) "
                + "and hocKy in (select top(1) hocKy from LopTinChi order by nienKhoa, hocKy desc))";
        try (Connection con = database.DatabaseHelper.getDBConnect(); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMon(rs.getNString("maMon"));
                mh.setTenMon(rs.getNString("tenMon"));
                mh.setNhom(rs.getInt("nhom"));
                mh.setSltclt(rs.getInt("sltclt"));
                mh.setSltcth(rs.getInt("Sltcth"));
                lstMHFiller.add(mh);
            }
            return lstMHFiller;
        }
    }
    public List<MonHoc> findByMaMH(String maMon) throws Exception {
        List<MonHoc> lstMHTimThay = new ArrayList<>();
        String sql = "select MonHoc.maMon, MonHoc.tenMon, LopTinChi.nhom, MonHoc.sltclt, MonHoc.sltcth from LopTinChi, MonHoc where LopTinChi.maMon = MonHoc.maMon and MonHoc.maMon = ?";
        try (
                Connection con = database.DatabaseHelper.getDBConnect();  
                PreparedStatement pstm = con.prepareStatement(sql);) 
        {
            pstm.setString(1, maMon);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                do {
                    MonHoc mh = new MonHoc();
                    mh.setMaMon(rs.getNString("maMon"));
                    mh.setTenMon(rs.getNString("tenMon"));
                    mh.setNhom(rs.getInt("nhom"));
                    mh.setSltclt(rs.getInt("sltclt"));
                    mh.setSltcth(rs.getInt("Sltcth"));
                    lstMHTimThay.add(mh);
                } while (rs.next());
                return lstMHTimThay;
            }
            return null;
        }
    }
    public List<MonHoc> getAllMH() throws Exception {
        List<MonHoc> lstMonHoc = new ArrayList<>();
        String sql = "select MonHoc.maMon, MonHoc.tenMon, LopTinChi.nhom, MonHoc.sltclt, MonHoc.sltcth from LopTinChi, MonHoc where LopTinChi.maMon = MonHoc.maMon";
        try (Connection con = database.DatabaseHelper.getDBConnect(); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMon(rs.getNString("maMon"));
                mh.setTenMon(rs.getNString("tenMon"));
                mh.setNhom(rs.getInt("nhom"));
                mh.setSltclt(rs.getInt("sltclt"));
                mh.setSltcth(rs.getInt("Sltcth"));
                lstMonHoc.add(mh);
            }
            return lstMonHoc;
        }
    }
    public List<MonHoc> getAllDSDK(String maSV) throws Exception {
        List<MonHoc> lstDSDK = new ArrayList<>();
        String sql = "select MonHoc.maMon, MonHoc.tenMon, LopTinChi.nhom, MonHoc.sltclt, MonHoc.sltcth from DangKiMon, LopTinChi, MonHoc where DangKiMon.maSV = ? "
                + "and DangKiMon.maLopTC = LopTinChi.maLopTC and LopTinChi.maMon = MonHoc.maMon";
        try (Connection con = database.DatabaseHelper.getDBConnect(); 
            PreparedStatement pstm = con.prepareStatement(sql);) {
            
            pstm.setString(1, maSV);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                MonHoc dsdk = new MonHoc();
                dsdk.setMaMon(rs.getNString("maMon"));
                dsdk.setTenMon(rs.getNString("tenMon"));
                dsdk.setNhom(rs.getInt("nhom"));
                dsdk.setSltclt(rs.getInt("sltclt"));
                dsdk.setSltcth(rs.getInt("Sltcth"));
                lstDSDK.add(dsdk);
            }
            return lstDSDK;
        }
    }
    // có sửa hàm insert
    public boolean insert(DangKiMon dsdk, String maMon, int slsvMax) throws Exception {
        String sql = "if not exists (select * from LopTinChi, DangKiMon where LopTinChi.maLopTC = DangKiMon.maLopTC and LopTinChi.maMon = ? and DangKiMon.maSV = ?)"
                + "and not exists (select maLopTC from DangKiMon group by maLopTC having maLopTC = ? and count(*) = ?)"
                + "insert into DangKiMon(maLopTC, maSV, diem) values(?, ?, -1)";
        try (Connection con = database.DatabaseHelper.getDBConnect();  
            PreparedStatement pstm = con.prepareStatement(sql);) {
            
            pstm.setString(1, maMon);
            pstm.setString(2, dsdk.getMaSV());
            pstm.setInt(3, dsdk.getMaLopTC());
            pstm.setInt(4, slsvMax);
            pstm.setInt(5, dsdk.getMaLopTC());
            pstm.setString(6, dsdk.getMaSV());
            return pstm.executeUpdate() > 0;
        }
    }
    public boolean delete(int maLopTC, String maSV) throws Exception {
        String sql = "if exists (select * from DangKiMon where maLopTC = ? and maSV = ? and diem = -1) delete from DangKiMon where maLopTC = ? and maSV = ?";
        try (Connection con = database.DatabaseHelper.getDBConnect();  
            PreparedStatement pstm = con.prepareStatement(sql);) {
            
            pstm.setInt(1, maLopTC);
            pstm.setString(2, maSV);
            pstm.setInt(3, maLopTC);
            pstm.setString(4, maSV);
            return pstm.executeUpdate() > 0;
        }
    }
    
    public boolean cancelLopTC(int slsvMin, int maLopTC) throws Exception {
        String sql = "if ? in (select maLopTC from DangKiMon group by maLopTC having count(*) < ?) "
                + "and not exists (select * from DangKiMon where diem != -1 and maLopTC = ?) "
                + "begin delete from DangKiMon where maLopTC = ?; delete from LopTinChi where maLopTC = ?; end";
        try (Connection con = database.DatabaseHelper.getDBConnect();  
            PreparedStatement pstm = con.prepareStatement(sql);) {
            
            pstm.setInt(1, maLopTC);
            pstm.setInt(2, slsvMin);
            pstm.setInt(3, maLopTC);
            pstm.setInt(4, maLopTC);
            pstm.setInt(5, maLopTC);
            return pstm.executeUpdate() > 0;
        }
    }
    
    public DangKiMon getDkmByID(int maLopTC, String maSV) {
        Connection conn = null;
        try {
            conn = database.DatabaseHelper.getDBConnect();
            PreparedStatement prst = conn.prepareStatement("Select * From DangKiMon dkm Where "
                    + " MaLopTC= ? AND dkm.MaSV = ?");
            prst.setInt(1, maLopTC);
            prst.setString(2, maSV);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                DangKiMon dkm = new DangKiMon();
                dkm.setMaLopTC(rs.getInt("maLopTC"));
                dkm.setMaSV(rs.getString("MaSV").trim());                
                dkm.setDiem(rs.getFloat("Diem"));
                return dkm;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }
    
    public boolean update(DangKiMon dkm) {
        Connection conn = null;
        try {
            conn = database.DatabaseHelper.getDBConnect();
            PreparedStatement prst = conn.prepareStatement("UPDATE DangKiMon SET Diem = ? "
                    + " WHERE MaLopTC = ? AND MaSV= ?");
            prst.setDouble(1, dkm.getDiem());
            prst.setInt(2, dkm.getMaLopTC());
            prst.setString(3, dkm.getMaSV());      
            prst.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
