package Control;

import DBHandler.DBNhaXuatBanHandler;
import Object.NhaXuatBan;

import java.util.ArrayList;
import java.util.Scanner;
import Validator.Validator;


public class NXBController {
    private DBNhaXuatBanHandler handler = new DBNhaXuatBanHandler();
    private Scanner sc = new Scanner(System.in);

    public void addNhaXuatBan(){
        System.out.println("Nhap MaNXB");
        int MaNXB = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap TenNXB");
        String TenNXB = sc.nextLine();
        while (!Validator.isValidName(TenNXB)) {
            System.out.println("Tên không hợp lệ");
            TenNXB = sc.nextLine();
        }
        System.out.println("Nhap Diachi");
        String DiaChi = sc.nextLine();
        System.out.println("Nhap Sdt");
        String Sdt = sc.nextLine();
        while (!Validator.isValidPhone(Sdt)){
            System.out.println("Số điện thoại không hợp lệ");
            Sdt = sc.nextLine();
        }


        NhaXuatBan nhaXuatBan = new NhaXuatBan(MaNXB,TenNXB,DiaChi,Sdt);

        if(handler.insertNhaXuatBan(nhaXuatBan)){
            System.out.println("NXB da dc luu");
        }else {
            System.out.println("Luu loi");
        }
    }

    public void deleteNhaXuatBan(){
        System.out.println("Enter the ma nhaxuatban ");
        int MaNXB = sc.nextInt();
        if(handler.deleteNhaXuatBan(MaNXB)){
            System.out.println("NXB "+MaNXB+ " deleted");
        } else{
            System.out.println("failed to delete book");
        }
    }

    public void updateNhaXuatBan(){
        System.out.println("Enter the MaNXB of the nhaxuatban: ");
        int MaNXB = sc.nextInt();

        NhaXuatBan nhaXuatBan= handler.getNhaXuatBan(MaNXB);
        if(nhaXuatBan == null){
            System.out.println("No such nhaxuatban exists with id "+MaNXB);
            return;
        }
        System.out.println("MaNXB: "+nhaXuatBan.getMaNXB());
        System.out.println("TenNXB: "+nhaXuatBan.getTenNXB());
        System.out.println("DiaChi: "+nhaXuatBan.getDiaChi());
        System.out.println("Sdt: "+nhaXuatBan.getSdt());

        System.out.println("enter new TenNXB: ");
        sc.nextLine();
        String newTenNXB = sc.nextLine();
        while (!Validator.isValidName(newTenNXB)) {
            System.out.println("Tên không hợp lệ");
            newTenNXB = sc.nextLine();
        }
        System.out.println("enter new DiaChi ");
        String newDiaChi = sc.nextLine();
        System.out.println("enter new Sdt ");
        String newSdt = sc.nextLine();
        while (!Validator.isValidPhone(newSdt)){
            System.out.println("Số điện thoại không hợp lệ");
            newSdt = sc.nextLine();
        }

        nhaXuatBan.TenNXB = newTenNXB;
        nhaXuatBan.DiaChi = newDiaChi;
        nhaXuatBan.Sdt = newSdt;

        if(handler.updateNhaXuatBan(nhaXuatBan)){
            System.out.println("NXB updated");
        }else{
            System.out.println("failed to update NXb");
        }
    }

    public void getListNXB(){
        ArrayList<NhaXuatBan> nhaXuatBans = handler.getListNXB();
        System.out.printf("%-10s %-25s %-20s %-15s\n", "MaNXB", "TenNXB", "DiaChi","Sdt");
        System.out.println("------------------------------------------------------");
        for (NhaXuatBan nhaXuatBan : nhaXuatBans) {
            System.out.printf("%-10s %-25s %-20s %-15s\n", nhaXuatBan.MaNXB,nhaXuatBan.TenNXB,nhaXuatBan.DiaChi,nhaXuatBan.Sdt);
        }
    }
}
