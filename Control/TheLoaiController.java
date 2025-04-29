package Control;

import Object.TheLoai;

import java.util.*;
import DBHandler.DBTheLoaiHandler;


public class TheLoaiController {
    private Scanner sc = new Scanner(System.in);
    private DBTheLoaiHandler handler = new DBTheLoaiHandler();

    public void addTheloai() {
        System.out.println("Enter the idTag of 'theloai': ");
        int idTag = sc.nextInt();
        System.out.println("Enter the name of 'theloai': ");
        sc.nextLine();
        String tentheloaisach = sc.nextLine();
        System.out.println("Enter the description of 'theloai': ");
        String description = sc.nextLine();


        TheLoai theloai = new TheLoai(idTag, tentheloaisach, description);

        if (handler.insertTheloai(theloai)) {
            System.out.println("Theloai added");
        } else {
            System.out.println("failed to add theloai");
        }

    }

    public void deleteTheloai() {
        System.out.println("Enter the idTag : ");
        int idTag = this.sc.nextInt();
        if (handler.deleteTheloai(idTag)) {
            System.out.println("The loai " + idTag + " deleted");
        } else {
            System.out.println("failed to delete theloai");
        }

    }

    public void updateTheloai() {
        System.out.println("Enter the name of 'theloai': ");
        int idTag = this.sc.nextInt();
        TheLoai theloai = handler.getTheloai(idTag);
        if (theloai == null) {
            System.out.println("No such theloai exists with id " + idTag);
        } else {
            System.out.println("Theloai ID: " + theloai.idTag);
            System.out.println("Theloai tentheloaisach: " + theloai.tentheloaisach);
            System.out.println("Theloai description: " + theloai.description);

            System.out.println("enter new theloai's tentheloaisach: ");
            this.sc.nextLine();
            String newTentheloaisach= this.sc.nextLine();
            System.out.println("enter new description: ");
            String newDescription = this.sc.nextLine();

            theloai.tentheloaisach = newTentheloaisach;
            theloai.description = newDescription;

            if (handler.updateTheloai(theloai)) {
                System.out.println("Theloai updated");
            } else {
                System.out.println("failed to update theloai");
            }

        }
    }

    public void getCactheloai() {
        ArrayList<TheLoai> theLoais = handler.getCacTheloai();
        System.out.printf("%-5s %-25s %-20s\n", "idTag", "tencactheloai", "description");
        System.out.println("------------------------------------------------------");

        for(TheLoai theLoai : theLoais) {
            System.out.printf("%-5d %-25s %-20s\n", theLoai.idTag, theLoai.tentheloaisach, theLoai.description);
        }

    }
}
