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
import model.MonHoc;
/**
 *
 * @author acer
 */
public class MonHocDAO {
    public static final String connectionUrl = "jdbc:sqlserver://localhost;"
            + "databaseName= QLSV2;user=sa;password=123;encrypt=false";
    
    public MonHoc getMonHocByMaMon( String maMon) {
        Connection conn = null;
        try {
            conn = database.DatabaseHelper.getDBConnect();
            PreparedStatement prst = conn.prepareStatement("Select * From MonHoc mh Where "
                    + " mh.MaMon = ?");
            prst.setString(1, maMon);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMon(maMon);
                mh.setTenMon(rs.getString("TenMon").trim());                
                mh.setSltclt(rs.getInt("Sltclt"));
                mh.setSltcth(rs.getInt("Sltcth"));
                return mh;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }
    
    public static List<MonHoc> findAll() throws ClassNotFoundException {
        
        List<MonHoc> list = new ArrayList<>();
        Connection conn = null;
        Statement statement = null; 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql = "select * from MonHoc order by ID";
            
            statement = conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                MonHoc mh = new MonHoc(resultSet.getString("maMon"),
                        resultSet.getInt("sltclt"), resultSet.getInt("sltcth"),resultSet.getInt("ID"), resultSet.getString("tenMon"));
                list.add(mh);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
        return list;
    }
    public static void insert(MonHoc mh) throws ClassNotFoundException{
        Connection conn = null;
        
        PreparedStatement statement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql = "insert into MonHoc(maMon,tenMon,sltclt,sltcth) values (?,?,?,?)";
            statement = conn.prepareCall(sql);
            
            statement.setString(1,mh.getMaMon());
            statement.setString(2,mh.getTenMon());
            statement.setInt(3,mh.getSltclt());
            statement.setInt(4,mh.getSltcth());
            
            statement.execute();
                    
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
    }
    public static void update(MonHoc mh) throws ClassNotFoundException{
        Connection conn = null;       
        PreparedStatement statement = null;
        try {
                
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql = "update MonHoc set maMon = ?,tenMon = ?,sltclt = ?,sltcth = ? where ID = ?";
            statement = conn.prepareCall(sql);
            
            statement.setString(1,mh.getMaMon());
            statement.setString(2,mh.getTenMon());
            statement.setInt(3,mh.getSltclt());
            statement.setInt(4,mh.getSltcth());
            statement.setInt(5, mh.getDem());
            statement.execute();
                    
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
    }
    public static void delete(String maMon) throws ClassNotFoundException{
        Connection conn = null;       
        PreparedStatement statement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql1 = "delete from LopTinChi where maMon like ?";
            statement = conn.prepareCall(sql1);        
            
            statement.setString(1, "%"+maMon+"%");
            
            statement.executeUpdate(); 
            String sql2 = "delete from MonHoc where maMon like ?";
            statement = conn.prepareCall(sql2);        
            
            statement.setString(1, "%"+maMon+"%");
            
            statement.executeUpdate(); 
                    
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
    }
    public static List<MonHoc> findByFullname(String fullname ) throws ClassNotFoundException {
        List<MonHoc> list = new ArrayList<>();
        Connection conn = null;
        
        PreparedStatement statement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            String sql = "select * from MonHoc where tenMon like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1,"%"+fullname+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MonHoc mh = new MonHoc(resultSet.getString("maMon"),
                        resultSet.getInt("sltclt"), resultSet.getInt("sltcth"), resultSet.getInt("ID"), resultSet.getString("tenMon"));
                list.add(mh);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
        return list;
    }
}
