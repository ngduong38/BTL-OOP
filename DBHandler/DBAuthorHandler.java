package DBHandler;

import Object.Author;
import java.sql.*;
import ConnectDB.DBConection;

import java.sql.Date;
import java.util.*;


public class DBAuthorHandler {
    public boolean insertAuthor(Author author) {
        boolean result=false;
        try{
            String sql="insert into author values(?,?,?,?)";
            Connection con= DBConection.getConnection();
            PreparedStatement stmt=con.prepareStatement(sql);

            stmt.setInt(1,author.idAuthor);
            stmt.setString(2,author.nameAuthor);
            stmt.setDate(3, Date.valueOf(author.birthday));
            stmt.setString(4,author.popularBook);

            int inserted=stmt.executeUpdate();
            result=inserted>=1;
            DBConection.disconnect(con);
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteAuthor(int idAuthor) {
        boolean result=false;
        try{
            String sql="delete from author where idAuthor=?";
            Connection con=DBConection.getConnection();

            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1,idAuthor);
            int delete=stmt.executeUpdate();
            result = delete>=1;

            DBConection.disconnect(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateAuthor(Author author){
        boolean result=false;
        try{
            String sql="update author set nameAuthor=?, Birthday=? , PopularBook=? where idAuthor=?";
            Connection con=DBConection.getConnection();

            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1,author.nameAuthor);
            stmt.setDate(2,Date.valueOf(author.birthday));
            stmt.setString(3,author.popularBook);
            stmt.setInt(4,author.idAuthor);
            int updated=stmt.executeUpdate();
            result = updated>=1;

            DBConection.disconnect(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public Author getAuthor(int idAuthor) {
        Author author =null;
        try{
            String sql="select * from author where idAuthor=?";
            Connection con=DBConection.getConnection();

            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1,idAuthor);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){

                author = new Author(rs.getInt(1),rs.getString(2),
                        rs.getDate(3).toLocalDate(),rs.getString(4));
            }
            DBConection.disconnect(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return author;
    }
    public ArrayList<Author> getAllAuthor() {
        ArrayList<Author> authors= new ArrayList<>();
        Author author=null;
        try{
            String sql="select * from author";
            Connection con=DBConection.getConnection();

            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                // book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3));
                author = new Author(rs.getInt(1),rs.getString(2),
                        rs.getDate(3).toLocalDate(),rs.getString(4));
                authors.add(author);
            }
            DBConection.disconnect(con);

        } catch(Exception e){
            e.printStackTrace();
        }
        return authors;
    }
}
