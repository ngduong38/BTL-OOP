package Control;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import DBHandler.DBPhieuPhatHandler;
import Feature.PhieuPhat;


public class PhieuPhatController {
    private Scanner sc = new Scanner(System.in);
    private DBPhieuPhatHandler fineHandler = new DBPhieuPhatHandler();

    public void issueFine() {
        System.out.print("Nhập mã phiếu mượn (mapm): ");
        int mapm = sc.nextInt();
        System.out.print("Nhập Họ và tên người bị phạt: ");
        String fullname = sc.nextLine();
        System.out.print("Nhập ngày mượn (YYYY-MM-DD): ");
        String ngayMuonStr = sc.nextLine();
//        LocalDate ngayMuon = LocalDate.parse(ngayMuonStr);
        System.out.print("Nhập ngày trả (YYYY-MM-DD): ");
        String ngayTraStr = sc.nextLine();
//        LocalDate ngayTra = LocalDate.parse(ngayTraStr);
        System.out.print("Nhập số tiền phạt: ");
        double tien = sc.nextDouble();

        PhieuPhat phieuPhat = new PhieuPhat(mapm, fullname, Date.valueOf(ngayMuonStr),Date.valueOf(ngayTraStr) ,tien);
        fineHandler.addPhieuPhat(phieuPhat);
    }
}
