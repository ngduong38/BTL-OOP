package DBHandler;

import java.sql.*;
import ConnectDB.DBConection;
import Feature.PhieuMuon;

public class DBPhieuMuonHandler {
    private Connection conn;

    public DBPhieuMuonHandler() {
        conn = DBConection.getConnection();
    }

    public void addPhieuMuon(PhieuMuon phieuMuon) {
        String sql = "INSERT INTO PhieuMuon (idtk, title, ngaymuon, hantra) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, phieuMuon.getIdtk());
            stmt.setString(2, phieuMuon.getTitle());
            stmt.setDate(3, phieuMuon.getNgaymuon());
            stmt.setDate(4, phieuMuon.getHantra());
            stmt.executeUpdate();
            System.out.println("Đã thêm phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
