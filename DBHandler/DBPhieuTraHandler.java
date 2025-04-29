package DBHandler;

import ConnectDB.DBConection;
import java.sql.*;
import Feature.PhieuTra;

import java.sql.Connection;

public class DBPhieuTraHandler {
    private Connection conn;

    public DBPhieuTraHandler() {
        conn = DBConection.getConnection();
    }

    public void addPhieuTra(PhieuTra phieuTra) {
        String sql = "INSERT INTO PhieuTra (idtk, title, ngaytra, trangthaibook) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, phieuTra.getIdtk());
            stmt.setString(2, phieuTra.getTitle());
            stmt.setDate(3, phieuTra.getNgaytra());
            stmt.setString(4, phieuTra.getTrangthaibook());
            stmt.executeUpdate();
            System.out.println("Đã thêm phiếu trả thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
