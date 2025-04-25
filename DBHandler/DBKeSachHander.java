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
            String sql = "Insert into kesach values(?,?,?)";
            Connection connection = DBConection.getCennection();

            //Create prepared statement
            PreparedStatement stmt = connection.prepareStatement(sql);

            // Set parameter values
            stmt.setInt(1,keSach.getMaKe());
            stmt.setString(2,keSach.getViTri());
            stmt.setInt(3,keSach.getTrangThai());

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
            String sql="delete from kesach where MaKe=?";
            Connection connection = DBConection.getCennection();

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
            String sql="update kesach set  ViTri=?,TrangThai=? where MaKe=?";
            Connection connection=DBConection.getCennection();

            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1,keSach.getMaKe());
            stmt.setString(2, keSach.getViTri());
            stmt.setInt(3, keSach.getTrangThai());
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
            String sql="select * from kesach where MaKe=?";
            Connection connection=DBConection.getCennection();

            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1,MaKe);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                keSach = new KeSach(rs.getInt(1),rs.getString(2),rs.getInt(3));
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
            String sql="select * from kesach";
            Connection con=DBConection.getCennection();

            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                keSach = new KeSach(rs.getInt(1),rs.getString(2),rs.getInt(3) );
                keSachs.add(keSach);
            }
            DBConection.disconnect(con);

        } catch(Exception e){
            e.printStackTrace();
        }
        return keSachs;
    }
}
