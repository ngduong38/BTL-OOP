package DBHandler;

import ConnectDB.DBConection;
import java.sql.*;
import Feature.PhieuPhat;

public class DBPhieuPhatHandler {
    private Connection conn;

    public DBPhieuPhatHandler() {
        conn = DBConection.getConnection();
    }

    public void addPhieuPhat(PhieuPhat phieuPhat) {
        String sql = "INSERT INTO PhieuPhat (mapt ,fullname,ngaymuon,ngaytra, tien) VALUES (?,?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, phieuPhat.getMapm());
            stmt.setInt(1, phieuPhat.getMapp());
            stmt.setString(2,phieuPhat.getFullname());
            stmt.setDate(3, phieuPhat.getNgaymuon());
            stmt.setDate(4,phieuPhat.getNgaytra());
            stmt.setDouble(5, phieuPhat.getTien());
            stmt.executeUpdate();
            System.out.println("Đã thêm phiếu phạt thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
