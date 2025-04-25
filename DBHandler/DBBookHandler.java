package DBHandler;

import java.sql.*;
import Object.Sach;
import ConnectDB.DBConection;

public class DBBookHandler {

    public boolean insertsach(Sach sach){
        boolean result =false;

        try {
            String sql = "Insert into sach values(?,?,?,?,?,?,?,?,?)";
            Connection connection = DBConection.getCennection();

            //Create prepared statement
            PreparedStatement stmt = connection.prepareStatement(sql);

            // Set parameter values
            stmt.setInt(1,sach.getMaSach());
            stmt.setString(2,sach.getTenSach());
            stmt.setInt(3,sach.getMaLoai());
            stmt.setInt(4,sach.getMaNXB());
            stmt.setInt(5,sach.getMaTacgia());
            stmt.setInt(6,sach.getNamxb());
            stmt.setInt(7,sach.getSoluong());
            stmt.setInt(8,sach.getMake());
            stmt.setInt(9,sach.getTrangThai());

            //Excute the Command
            int inserted = stmt.executeUpdate();

            result = inserted >=1;

            DBConection.disconnect(connection);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteSach(int MaSach){
        boolean result=false;
        try{
            String sql="delete from sach where MaSach=?";
            Connection connection = DBConection.getCennection();

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,MaSach);
            int delete=stmt.executeUpdate();
            result = delete>=1;

            DBConection.disconnect(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
