package DBHandler;

import java.sql.*;
import java.security.*;
import java.math.*;

import ConnectDB.DBConection;
import Object.User;

public class DBUserHandler {
    public static String passwordHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            String hashedPassword = new BigInteger(1, digest).toString(16);
            return hashedPassword;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertUser(User user) {
        boolean result = false;
        try {
            String sql = "insert into user (username,password,fullname,tuoi,phone,address) values(?,?,?,?,?,?)";
            Connection con = DBConection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, user.UserName);
            stmt.setString(2, user.PassWord);
            stmt.setString(3, user.FullName);
            stmt.setInt(4, user.Tuoi);
            stmt.setInt(5, user.PhoneNumber);
            stmt.setString(6, user.Address);

            int inserted = stmt.executeUpdate();
            result = inserted >= 1;
            DBConection.disconnect(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateUser( String FullName,int Tuoi, int PhoneNumber, String Address,String UserName) {
        boolean result=false;
        try{
            String sql="update user set fullname=?,tuoi=?,phone=?, address=? where username=?";
            Connection con=DBConection.getConnection();

            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1,FullName);
            stmt.setInt(2,Tuoi);
            stmt.setInt(3,PhoneNumber);
            stmt.setString(4,Address);
            stmt.setString(5,UserName);
            int updated=stmt.executeUpdate();
            result = updated>=1;

            DBConection.disconnect(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public String get_hashedpassword(String username) {
        String result = null;
        try {
            String sql = "select password from user where username = ?";
            Connection con = DBConection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                result = rs.getString(1);
            } else {
                System.out.println("Không tìm thấy user: " + username);
            }
            DBConection.disconnect(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public User getUser(String UserName) {
        User user = null;
        try {
            String sql = "select * from user where username = ?";
            Connection con = DBConection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, UserName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                user = new User(rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getInt(5),rs.getInt(6)
                        ,rs.getString(7));
            }
            DBConection.disconnect(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
