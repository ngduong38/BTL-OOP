package Asstribute;

import DBHandler.DBKeSachHander;
import java.util.ArrayList;
import java.util.Scanner;
import Object.KeSach;

public class KeSachController {
    private DBKeSachHander handler = new DBKeSachHander();
    private Scanner sc = new Scanner(System.in);

    public void addKeSach(){
        System.out.println("Nhap MaKe");
        int MaKe = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ViTri");
        String Vitri = sc.nextLine();
        System.out.println("Nhap TrangThai");
        int TrangThai = sc.nextInt();

        KeSach keSach = new KeSach(MaKe,Vitri,TrangThai);

        if (handler.insertKeSach(keSach)){
            System.out.println("Ke Sach da dc luu");
        } else {
            System.out.println("Luu loi");
        }
    }

    public void deleteKeSach(){
        System.out.println("Enter the kesach of the book: ");
        int MaKe = sc.nextInt();
        if(handler.deleteKSach(MaKe)){
            System.out.println("MaKe"+MaKe+ " deleted");
        } else{
            System.out.println("failed to delete book");
        }
    }

    public void updateKeSach(){
        System.out.println("Enter the MaKe of the kesach: ");
        int MaKe = sc.nextInt();

        KeSach keSach= handler.getKeSach(MaKe);
        if(keSach == null){
            System.out.println("No such kesach exists with id "+MaKe);
            return;
        }
        System.out.println("MaKe: "+keSach.getMaKe());
        System.out.println("ViTri: "+keSach.getViTri());
        System.out.println("TrangThai: "+keSach.getTrangThai());

        System.out.println("enter new ViTri: ");
        sc.nextLine();
        String newViTri = sc.nextLine();

        keSach.ViTri = newViTri;

        if(handler.updateKeSach(keSach)){
            System.out.println("KeSach updated");
        }else{
            System.out.println("failed to update KeSach");
        }
    }
    public void getListKeSach(){
        ArrayList<KeSach> keSachs = handler.getListKeSach();
        System.out.printf("%-5s %-25s %-20s\n", "MaKe", "ViTri","TrangThai");
        System.out.println("------------------------------------------------------");
        for (KeSach keSach : keSachs) {
            System.out.printf("%-5s %-25s %-20s\n", keSach.MaKe,keSach.ViTri,keSach.TrangThai);
        }
    }
}
