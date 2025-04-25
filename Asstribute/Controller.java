package Asstribute;

import java.util.*;



public class Controller {
    private Scanner sc = new Scanner(System.in);
    private NXBController nxbController = new NXBController();
    private SachController sachController = new SachController();
    private KeSachController keSachController = new  KeSachController();

    private int Menu() {
        System.out.println("Menu");
        System.out.println("1 Sach");
        System.out.println("2 NXB");
        System.out.println("3 Ke Sach");
        System.out.println("4 thong tin sach");
        System.out.println("Thoát");

        int choice0;
        do {
            System.out.println("nhap lua chon");
            choice0 = sc.nextInt();
        }while (choice0 <1 || choice0 >5);
            return choice0;
    }

    private int MenuSach(){
        System.out.println("1 Them sach");
        System.out.println("2 Xoa sach");
        System.out.println("3 Sua Sach");
        System.out.println("4 Danh sách sách");
        System.out.println("Thoát");
        int choice1;
        do {
            System.out.println("nhap lua chon");
            choice1 = sc.nextInt();
        }while (choice1 <1 || choice1 >5);
        return choice1;
    }

    private int MenuNXB(){
        System.out.println("1 Them NXB");
        System.out.println("2 Xoa NXB");
        System.out.println("3 Sua NXB");
        System.out.println("4 Danh sach NXB");
        System.out.println("Thoát");
        int choice2;;
        do {
            System.out.println("nhap lua chon");
            choice2 = sc.nextInt();
        }while (choice2 <1 || choice2 >5);
        return choice2;
    }

    private int MenuKeSach(){
        System.out.println("1 Them Ke Sach");
        System.out.println("2 Xoa Ke Sach");
        System.out.println("3 Sua Ke Sach");
        System.out.println("4 Danh Sach Ke Sach");
        System.out.println("Thoat");
        int choice3;;
        do {
            System.out.println("nhap lua chon");
            choice3 = sc.nextInt();
        }while (choice3 <1 || choice3 >5);
        return choice3;
    }


    public void runApp(){
         int choice0;
         do {
             choice0 = Menu();
             System.out.println();
             if (choice0 == 1) {
                 int choice1;
                 do {
                     choice1 = MenuSach();
                     System.out.println();
                     if (choice1 == 1){
                         sachController.addSach();
                     }
                     if (choice1 == 2){
                         sachController.deleteSach();
                     }
                 }while (choice1 != 5);
             }
             if (choice0 ==2){
                 int choice2;
                 do {
                     choice2 = MenuNXB();
                     System.out.println();
                     if (choice2 == 1){
                         nxbController.addNhaXuatBan();
                     }
                     if (choice2 == 2){
                         nxbController.deleteNhaXuatBan();
                     }
                     if (choice2 == 3){
                         nxbController.updateNhaXuatBan();
                     }
                     if (choice2 == 4){
                         nxbController.getListNXB();
                     }
                 }while (choice2 != 5);
             }
             if (choice0 ==3){
                 int choice3;
                 do {
                     choice3 = MenuKeSach();
                     System.out.println();
                     if (choice3 == 1){
                         keSachController.addKeSach();
                     }
                     if (choice3 == 2){
                         keSachController.deleteKeSach();
                     }
                     if (choice3 == 3){
                         keSachController.updateKeSach();
                     }
                     if (choice3 == 4){
                         keSachController.getListKeSach();
                     }
                 }while (choice3 != 5);
             }
         }while ( choice0 != 5);
    }
}