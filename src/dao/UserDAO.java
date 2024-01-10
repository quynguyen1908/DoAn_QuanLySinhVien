/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.User;
/**
 *
 * @author acer
 */
public class UserDAO {
    public boolean  checkLogin(String username, String pass)
    {
        User user = getUserByID(username);
        if(user != null)  // ton tai username
        {
            if(user.getPassword().equals(pass))
            {
                return true;
            }
        }
        return false;
    }
    
    public User getUserByID(String username)
    {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        User u = new User();
        username = username.toUpperCase();
        try {
            String sSQL = "select * from Users where username = ?";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, username);
            rs = sttm.executeQuery();
            while (rs.next()) {
                u.setUsername(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setRole(rs.getBoolean(3));
                return u;
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
    
    public int add(User u)
    {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into Users(username, password, role) values(?, ?, ?)";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, u.getUsername());
            sttm.setString(2, u.getPassword());
            sttm.setBoolean(3, u.isRole());
            if(sttm.executeUpdate() > 0)
            {
                System.out.println("Them tai khoan thanh cong");
                return 1;
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int deleteUserByID(String username)
    {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete from Users where username = ?";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, username);
            if(sttm.executeUpdate() > 0)
            {
                System.out.println("Xoa tai khoan thanh cong");
                return 1;
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int updatePassUser(String username, String pass)
    {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update Users set password = ? where username = ?";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, pass);
            sttm.setString(2, username);
            if(sttm.executeUpdate() > 0)
            {
                System.out.println("Cap nhat tai khoan thanh cong");
                return 1;
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
}

