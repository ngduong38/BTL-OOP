package DBHandler;

import Object.TheLoai;
import java.sql.*;
import java.util.*;

import ConnectDB.DBConection;

public class DBTheLoaiHandler {
    public boolean insertTheloai(TheLoai theloai){
        boolean result=false;
        try{
            String sql="insert into theloai values(?,?,?)";
            Connection con= DBConection.getConnection();
            PreparedStatement stmt=con.prepareStatement(sql);

            stmt.setInt(1,theloai.idTag);
            stmt.setString(2,theloai.tentheloaisach);
            stmt.setString(3,theloai.description);

            int inserted=stmt.executeUpdate();
            result=inserted>=1;
            DBConection.disconnect(con);
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteTheloai(int idTag){
        boolean result=false;
        try{
            String sql="delete from theloai where idTag=?";
            Connection con = DBConection.getConnection();

            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1,idTag);
            int delete=stmt.executeUpdate();
            result = delete>=1;

            DBConection.disconnect(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateTheloai(TheLoai theloai){
        boolean result=false;
        try{
            String sql="update theloai set tentheloaisach=?, mieuta=? where idTag=?";
            Connection con=DBConection.getConnection();

            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1,theloai.tentheloaisach);
            stmt.setString(2,theloai.description);
            stmt.setInt(3,theloai.idTag);
            int updated=stmt.executeUpdate();
            result = updated>=1;

            DBConection.disconnect(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public TheLoai getTheloai(int idTag ){
        TheLoai theloai=null;
        try{
            String sql="select * from theloai where idTag=?";
            Connection con = DBConection.getConnection();

            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1,idTag);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                theloai = new TheLoai(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
            DBConection.disconnect(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return theloai;
    }
    public ArrayList<TheLoai> getCacTheloai(){
        ArrayList<TheLoai> cactheloai= new ArrayList<TheLoai>();
        TheLoai theLoai = null;
        try{
            String sql="select * from theloai";
            Connection con=DBConection.getConnection();

            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                theLoai = new TheLoai(rs.getInt(1),rs.getString(2),rs.getString(3));
                cactheloai.add(theLoai);
            }
            DBConection.disconnect(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return cactheloai;
    }
}
