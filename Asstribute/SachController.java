package Asstribute;

import DBHandler.DBBookHandler;
import Object.Sach;
import java.util.Scanner;

public class SachController {
    private Scanner sc = new Scanner(System.in);
    private DBBookHandler handler = new DBBookHandler();

    public void addSach(){
        System.out.println("Nhap MaSach");
        int MaSach = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap TenSach");
        String TenSach = sc.nextLine();
        System.out.println("Nhap MaLoai");
        int MaLoai = sc.nextInt();
        System.out.println("Nhap MaNXB");
        int MaNXB = sc.nextInt();
        System.out.println("Nhap MaTacgia");
        int MaTacgia = sc.nextInt();
        System.out.println("Nhap NamXB");
        int NamXB = sc.nextInt();
        System.out.println("Nhap Soluong");
        int SoLuong = sc.nextInt();
        System.out.println("Nhap Make");
        int Make = sc.nextInt();
        System.out.println("Nhap TrangThai");
        int TrangThai = sc.nextInt();

        Sach sach = new Sach(MaSach,TenSach,MaLoai,MaNXB,MaTacgia,NamXB,SoLuong,Make,TrangThai);

        if(handler.insertsach(sach)){
            System.out.println(("Sach da dc luu"));
        }else {
            System.out.println("Luu loi");
        }
    }

    public void deleteSach(){
        System.out.println("Enter the MaSach of the book: ");
        int MaSach = sc.nextInt();
        if(handler.deleteSach(MaSach)){
            System.out.println("Book "+MaSach+ " deleted");
        } else{
            System.out.println("failed to delete book");
        }
    }
}
