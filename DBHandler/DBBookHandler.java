package DBHandler;
import java.util.*;
import java.sql.*;
import Object.Book;
import ConnectDB.DBConection;

public class DBBookHandler {

    public boolean insertBook(Book book) {
        boolean result = false;
        try {
            String sql = "insert into book values(?,?,?,?,?,?)";
            Connection con = DBConection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, book.idbook);
            stmt.setInt(2, book.idTag);
            stmt.setInt(3, book.idAuthor);
            stmt.setInt(4, book.maNXB);
            stmt.setString(5, book.title);
            stmt.setInt(6, book.soluong);


            int inserted = stmt.executeUpdate();
            result = inserted >= 1;
            DBConection.disconnect(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteBook(int idbook) {
        boolean result = false;
        try {
            String sql = "delete from book where idBook=?";
            Connection con = DBConection.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idbook);
            int delete = stmt.executeUpdate();
            result = delete >= 1;

            DBConection.disconnect(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateBook(Book book) {
        boolean result = false;
        try {
            String sql = "update book set tentheloaisach=?, idAuthor=? , maNXB=?, title=?, soluong=? where idBook=?";
            Connection con = DBConection.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, book.idTag);
            stmt.setInt(2, book.idAuthor);
            stmt.setInt(3, book.maNXB);
            stmt.setString(4, book.title);
            stmt.setInt(5, book.soluong);
            stmt.setInt(6, book.idbook);

            int updated = stmt.executeUpdate();
            result = updated >= 1;

            DBConection.disconnect(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Book getBook(int idbook) {
        Book book = null;
        try {
            String sql = "select * from book where idBook=?";
            Connection con = DBConection.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idbook);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                book = new Book(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4), rs.getString(5), rs.getInt(6));
            }
            DBConection.disconnect(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        Book book = null;
        try {
            String sql = "select * from book";
            Connection con = DBConection.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3));
                book = new Book(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4), rs.getString(5), rs.getInt(6));
                books.add(book);
            }
            DBConection.disconnect(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}

