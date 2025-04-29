package Control;

import DBHandler.DBKeSachHander;
import java.util.ArrayList;
import java.util.Scanner;
import Object.KeSach;
import Validator.Validator;

public class KeSachController {
    private DBKeSachHander handler = new DBKeSachHander();
    private Scanner sc = new Scanner(System.in);

    public void addKeSach(){
        System.out.println("Nhap MaKe");
        int MaKe = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ViTri");
        int Vitri = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap TrangThai");
        String TrangThai = sc.nextLine();
        System.out.println("Nhap ten ke");
        String TenKe = sc.nextLine().trim();
        while (!Validator.isValidTenKeSach(TenKe) || TenKe.isEmpty()){
            System.out.println("Tên kệ không hợp lệ");
            TenKe = sc.nextLine().trim();
        }
        System.out.println("Nhap Id Tag");
        int IdTag = sc.nextInt();
        while (!Validator.isValidIdTag(IdTag) ){
            System.out.println("Mã Tag không hợp lệ");
            IdTag = sc.nextInt();
        }

        KeSach keSach = new KeSach(MaKe,TenKe,TrangThai,Vitri,IdTag);

        if (handler.insertKeSach(keSach)){
            System.out.println("Ke Sach da dc luu");
        } else {
            System.out.println("Luu loi");
        }
    }

    public void deleteKeSach(){
        System.out.println("Enter the Make of the ke: ");
        int MaKe = sc.nextInt();
        if(handler.deleteKSach(MaKe)){
            System.out.println("MaKe"+MaKe+ " deleted");
        } else{
            System.out.println("failed to delete book");
        }
    }

    public void updateKeSach(){
        System.out.println("Enter the MaKe of the ke: ");
        int MaKe = sc.nextInt();

        KeSach keSach= handler.getKeSach(MaKe);
        if(keSach == null){
            System.out.println("No such ke exists with id "+MaKe);
            return;
        }
        System.out.println("MaKe: "+keSach.getMaKe());
        System.out.println("ViTri: "+keSach.getViTri());
        System.out.println("TrangThai: "+keSach.getTrangThai());
        System.out.println("IdTag:"+keSach.getIdTag());

        System.out.println("enter new ViTri: ");
        sc.nextLine();
        int newViTri = sc.nextInt();
        System.out.println("enter new ten ke");
        String newTenKe = sc.nextLine();
        while (!Validator.isValidTenKeSach(newTenKe)){
            System.out.println("Tên kệ không hợp lệ");
            newTenKe = sc.nextLine();
        }
        System.out.println("enter new IdTag");
        int newIdTag = sc.nextInt();
        while (!Validator.isValidIdTag(newIdTag)){
            System.out.println("Mã Tag không hợp lệ");
            newIdTag = sc.nextInt();
        }

        keSach.ViTri = newViTri;
        keSach.TenKe = newTenKe;
        keSach.IdTag = newIdTag;

        if(handler.updateKeSach(keSach)){
            System.out.println("KeSach updated");
        }else{
            System.out.println("failed to update KeSach");
        }
    }
    public void getListKeSach(){
        ArrayList<KeSach> keSachs = handler.getListKeSach();
        System.out.printf("%-5s %-25s %-20s %-10s %-10s\n", "MaKe","TenKe","TrangThai","IdTag", "ViTri");
        System.out.println("------------------------------------------------------");
        for (KeSach keSach : keSachs) {
            System.out.printf("%-5s %-25s %-20s %-10s\n",
                    keSach.MaKe,keSach.TenKe,keSach.TrangThai, keSach.IdTag,keSach.ViTri);
        }
    }
}
