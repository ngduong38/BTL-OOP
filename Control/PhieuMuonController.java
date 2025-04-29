package Control;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;
import DBHandler.DBPhieuMuonHandler;
import Feature.PhieuMuon;

public class PhieuMuonController {
    private Scanner sc = new Scanner(System.in);
    private DBPhieuMuonHandler phieuMuonHandler = new DBPhieuMuonHandler();

    public void borrowBook() {
        System.out.print("Nhập ID tài khoản: ");
        int idtk = sc.nextInt();
        System.out.print("Nhập ID sách: ");
        String title = sc.nextLine();
        sc.nextLine(); // Clear buffer

        System.out.print("Nhập ngày mượn (YYYY-MM-DD): ");
        String ngayMuonStr = sc.nextLine();
        LocalDate ngayMuon = LocalDate.parse(ngayMuonStr);

        LocalDate hanTraStr = ngayMuon.plusDays(7);
        System.out.print("Hạn trả (YYYY-MM-DD): "+ hanTraStr);

        PhieuMuon phieuMuon = new PhieuMuon(0, idtk, title, Date.valueOf(ngayMuonStr), Date.valueOf(hanTraStr));
        phieuMuonHandler.addPhieuMuon(phieuMuon);
    }

}
