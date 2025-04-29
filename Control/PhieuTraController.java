package Control;

import DBHandler.DBPhieuTraHandler;
import java.sql.*;
import Feature.PhieuTra;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;


public class PhieuTraController {
    private Scanner sc = new Scanner(System.in);
    private DBPhieuTraHandler returnHandler = new DBPhieuTraHandler();

    public void returnBook() {
        System.out.print("Nhập ID tài khoản: ");
        int idtk = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập ten sách: ");
        String title = sc.nextLine();
        System.out.print("Nhập ngày trả (YYYY-MM-DD): ");
        String ngayTraStr = sc.nextLine();
//        LocalDate ngayTra = LocalDate.parse(ngayTraStr);
        System.out.print("Nhập trạng thái sách (Tốt/Hỏng/Mất): ");
        String trangThai = sc.nextLine();

        PhieuTra phieuTra = new PhieuTra(0, idtk, title, Date.valueOf(ngayTraStr), trangThai);
        returnHandler.addPhieuTra(phieuTra);
    }
}
