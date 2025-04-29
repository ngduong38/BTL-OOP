package DBHandler;

import ConnectDB.DBConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Object.KeSach;

public class DBKeSachHander {
    public boolean insertKeSach(KeSach keSach){
        boolean result =false;

        try {
            String sql = "Insert into ke values(?,?,?,?,?)";
            Connection connection = DBConection.getConnection();

            //Create prepared statement
            PreparedStatement stmt = connection.prepareStatement(sql);

            // Set parameter values
            stmt.setInt(1,keSach.getMaKe());
            stmt.setString(2,keSach.getTenKe());
            stmt.setString(3,keSach.getTrangThai());
            stmt.setInt(4,keSach.getIdTag());
            stmt.setInt(5,keSach.getViTri());



            //Excute the Command
            int inserted = stmt.executeUpdate();

            result = inserted >=1;

            DBConection.disconnect(connection);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteKSach(int MaKe){
        boolean result=false;
        try{
            String sql="delete from ke where maKe=?";
            Connection connection = DBConection.getConnection();

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,MaKe);
            int delete=stmt.executeUpdate();
            result = delete>=1;

            DBConection.disconnect(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateKeSach(KeSach keSach){
        boolean result=false;
        try{
            String sql="update ke set idTag=?, vitri=?,trangthai=?,tenkesach=?, where maKe=?";
            Connection connection=DBConection.getConnection();

            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1,keSach.getMaKe());
            stmt.setString(2,keSach.getTenKe());
            stmt.setString(3, keSach.getTrangThai());
            stmt.setInt(4,keSach.getIdTag());
            stmt.setInt(5, keSach.getViTri());


            int updated=stmt.executeUpdate();
            result = updated>=1;

            DBConection.disconnect(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public KeSach getKeSach(int MaKe){
        KeSach keSach=null;
        try{
            String sql="select * from ke where maKe=?";
            Connection connection=DBConection.getConnection();

            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1,MaKe);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                keSach = new KeSach(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getInt(4),rs.getInt(5));
            }
            DBConection.disconnect(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
        return keSach;
    }
    public ArrayList<KeSach> getListKeSach(){
        ArrayList<KeSach>  keSachs= new ArrayList<KeSach>();
        KeSach keSach=null;
        try{
            String sql="select * from ke";
            Connection con=DBConection.getConnection();

            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                keSach = new KeSach(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getInt(4),rs.getInt(5));
                keSachs.add(keSach);
            }
            DBConection.disconnect(con);

        } catch(Exception e){
            e.printStackTrace();
        }
        return keSachs;
    }
}
