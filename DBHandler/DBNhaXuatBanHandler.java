package DBHandler;
import Object.NhaXuatBan;
import ConnectDB.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBNhaXuatBanHandler {
    public boolean insertNhaXuatBan(NhaXuatBan nhaXuatBan){
        boolean result =false;

        try {
            String sql = "Insert into nhaxuatban values(?,?,?,?)";
            Connection connection = DBConection.getConnection();

            //Create prepared statement
            PreparedStatement stmt = connection.prepareStatement(sql);

            // Set parameter values
            stmt.setInt(1,nhaXuatBan.getMaNXB());
            stmt.setString(2,nhaXuatBan.getTenNXB());
            stmt.setString(3,nhaXuatBan.getDiaChi());
            stmt.setString(4,nhaXuatBan.getSdt());


            //Excute the Command
            int inserted = stmt.executeUpdate();

            result = inserted >=1;

            DBConection.disconnect(connection);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteNhaXuatBan(int MaNXB){
        boolean result=false;
        try{
            String sql="delete from nhaxuatban where maNXB=?";
            Connection connection = DBConection.getConnection();

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,MaNXB);
            int delete=stmt.executeUpdate();
            result = delete>=1;

            DBConection.disconnect(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateNhaXuatBan(NhaXuatBan nhaXuatBan){
        boolean result=false;
        try{
            String sql="update nhaxuatban set TenNXB=?, Diachi=?,Sdt=? where maNXB=?";
            Connection connection=DBConection.getConnection();

            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1,nhaXuatBan.getMaNXB());
            stmt.setString(2, nhaXuatBan.getTenNXB());
            stmt.setString(3, nhaXuatBan.getDiaChi());
            stmt.setString(4,nhaXuatBan.getSdt());
            int updated=stmt.executeUpdate();
            result = updated>=1;

            DBConection.disconnect(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public NhaXuatBan getNhaXuatBan(int MaNXB){
        NhaXuatBan nhaXuatBan=null;
        try{
            String sql="select * from nhaxuatban where maNXB=?";
            Connection connection=DBConection.getConnection();

            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1,MaNXB);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                nhaXuatBan = new NhaXuatBan(rs.getInt(1),rs.getString(2),
                        rs.getString(3), rs.getNString(4));
            }
            DBConection.disconnect(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
        return nhaXuatBan;
    }
    public ArrayList<NhaXuatBan> getListNXB(){
        ArrayList<NhaXuatBan> nhaXuatBans= new ArrayList<NhaXuatBan>();
        NhaXuatBan nhaXuatBan=null;
        try{
            String sql="select * from nhaxuatban";
            Connection con=DBConection.getConnection();

            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                nhaXuatBan = new NhaXuatBan(rs.getInt(1),rs.getString(2),
                        rs.getString(3), rs.getNString(4) );
                nhaXuatBans.add(nhaXuatBan);
            }
            DBConection.disconnect(con);

        } catch(Exception e){
            e.printStackTrace();
        }
        return nhaXuatBans;
    }
}
