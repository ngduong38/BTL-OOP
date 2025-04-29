package Control;

import java.util.*;



public class Controller {
    private Scanner sc = new Scanner(System.in);
    private NXBController nxbController = new NXBController();
    private BookController bookController = new BookController();
    private KeSachController keSachController = new  KeSachController();
    private UserController userController = new UserController();
    private TheLoaiController theLoaiController = new TheLoaiController();
    private AuthorController authorController = new AuthorController();
    private PhieuMuonController phieuMuonController = new PhieuMuonController();
    private PhieuTraController phieuTraController = new PhieuTraController();
    private PhieuPhatController phieuPhatController = new PhieuPhatController();

    public int Login(){
        System.out.println("1. Login ");
        System.out.println("2. Sign Up ");
        int choice0;
        do{
            System.out.print("Enter your choice: ");
            choice0 = sc.nextInt();
        } while(choice0 < 1 || choice0 > 2);
        return choice0;
    }

    public int UserMenu(){
        System.out.println("Library management system");
        System.out.println("1. Cập nhật thông tin cá nhân");
        System.out.println("2. danh mục các sách");
        System.out.println("3. Xem vị trí sách");
        System.out.println("4. Mượn sách");
        System.out.println("5 Trả Sách");
        System.out.println("0. Đăng xuất");
        int UserChoice;
        do{
            System.out.print("Enter your choice: ");
            UserChoice = sc.nextInt();
        } while(UserChoice < 0 || UserChoice > 7);
        return UserChoice;
    }


    public int AdminMenu(){
        System.out.println("Library management system");
        System.out.println("1. Qly sach");
        System.out.println("2. Qly tac gia");
        System.out.println("3. Qly the loai");
        System.out.println("4. Qly NXB");
        System.out.println("5. Qly user");
        System.out.println("6. Qly ke sach");
        System.out.println("7 Sử phạt");
        System.out.println("0. Đăng xuất");
        int AdminChoice;
        do{
            System.out.print("Enter your choice: ");
            AdminChoice = sc.nextInt();
        } while(AdminChoice < 0 || AdminChoice > 8);
        return AdminChoice;
    }


    private int MenuBook(){
        System.out.println("1 Them sach");
        System.out.println("2 Xoa sach");
        System.out.println("3 Sua Sach");
        System.out.println("4 Danh sách Sách");
        System.out.println("0 Thoát");
        int choice1;
        do {
            System.out.println("nhap lua chon");
            choice1 = sc.nextInt();
        }while (choice1 <0 || choice1 >5);
        return choice1;
    }

    private int MenuAuthor() {
        System.out.println("1 Them Tac gia");
        System.out.println("2 Xoa Tac gia");
        System.out.println("3 Sua Tac gia");
        System.out.println("4 Danh sách Tac gia");
        System.out.println("0 Thoát");
        int choice1;
        do {
            System.out.println("nhap lua chon");
            choice1 = sc.nextInt();
        }while (choice1 <0 || choice1 >5);
        return choice1;
    }

    private int MenuNXB(){
        System.out.println("1 Them NXB");
        System.out.println("2 Xoa NXB");
        System.out.println("3 Sua NXB");
        System.out.println("4 Danh sach NXB");
        System.out.println("0 Thoát");
        int choice2;;
        do {
            System.out.println("nhap lua chon");
            choice2 = sc.nextInt();
        }while (choice2 <0 || choice2 >5);
        return choice2;
    }

    private int MenuKeSach(){
        System.out.println("1 Them Ke Sach");
        System.out.println("2 Xoa Ke Sach");
        System.out.println("3 Sua Ke Sach");
        System.out.println("4 Danh Sach Ke Sach");
        System.out.println("0 Thoat");
        int choice5;;
        do {
            System.out.println("nhap lua chon");
            choice5 = sc.nextInt();
        }while (choice5 <0 || choice5 >5);
        return choice5;
    }

    private int MenuUser(){
        System.out.println("1 Them User");
        System.out.println("2 Xoa User");
        System.out.println("3 Sua User");
        System.out.println("4 Danh Sach User");
        System.out.println("0 Thoat");
        int choice4;;
        do {
            System.out.println("nhap lua chon");
            choice4 = sc.nextInt();
        }while (choice4 <0 || choice4 >5);
        return choice4;
    }

    private int MenuTheLoai(){
        System.out.println("1 Them the loai");
        System.out.println("2 Xoa the loai");
        System.out.println("3 Sua the loai");
        System.out.println("4 Danh sach the loai");
        System.out.println("0 Thoát");
        int choice3;
        do {
            System.out.println("nhap lua chon");
            choice3 = sc.nextInt();
        }while (choice3 <0 || choice3 >5);
        return choice3;
    }


    public void runApp() {
        int choice0;
        do {
            choice0 = Login();
            System.out.println();

            if (choice0 == 1) {
                String Logged = userController.login();
                if ("admin".equals(Logged)) {
                    // Admin
                    boolean AdminLogged = true;
                    while (AdminLogged) {
                        int AdminChoice = AdminMenu();
                        switch (AdminChoice) {
                            case 1:
                                int choiceBook = MenuBook();
                                switch (choiceBook){
                                    case 1:
                                        bookController.addBook();
                                        MenuBook();
                                        break;
                                    case 2:
                                        bookController.getListBooks();
                                        MenuBook();
                                        break;
                                    case 3:
                                        bookController.updateBook();
                                        MenuBook();
                                        break;
                                    case 4:
                                        bookController.getListBooks();
                                        MenuBook();
                                        break;
                                    case 0:
                                        System.out.println("Thoat MenuBook\n");
                                        sc.nextLine();
                                        AdminMenu();
                                        break;

                                }
                                break;

                            case 2: /*Menu tac gia*/
                                int choiceAuthor = MenuAuthor();
                                switch (choiceAuthor){
                                    case 1:
                                        authorController.addAuthor();
                                        sc.nextLine();
                                        MenuAuthor();
                                        break;
                                    case 2:
                                        authorController.deleteAuthor();
                                        sc.nextLine();
                                        MenuAuthor();
                                        break;
                                    case 3:
                                        authorController.updateAuthor();
                                        sc.nextLine();
                                        MenuAuthor();
                                        break;
                                    case 4:
                                        authorController.getListAuthor();
                                        sc.nextLine();
                                        MenuAuthor();
                                        break;
                                    case 0:
                                        System.out.println("Thoat MenuAuthor\n");
                                        sc.nextLine();
                                        AdminMenu();
                                        break;
                                }
                                break;

                            case 3:
                                int choiceTheLoai = MenuTheLoai();
                                switch (choiceTheLoai) {
                                    case 1:
                                        theLoaiController.addTheloai();
                                        MenuTheLoai();
                                        break;
                                    case 2:
                                        theLoaiController.deleteTheloai();
                                        MenuTheLoai();
                                        break;
                                    case 3:
                                        theLoaiController.updateTheloai();
                                        MenuTheLoai();
                                        break;
                                    case 4:
                                        theLoaiController.getCactheloai();
                                        MenuTheLoai();
                                        break;
                                    case 0:
                                        System.out.println("Thoat menu The Loai\n");
                                        sc.nextLine();
                                        AdminMenu();
                                        break;
                                }
                                break;

                            case 4:
                                int choiceNXB = MenuNXB();
                                switch (choiceNXB) {
                                    case 1:
                                        nxbController.addNhaXuatBan();
                                        MenuNXB();
                                        break;
                                    case 2:
                                        nxbController.deleteNhaXuatBan();
                                        MenuNXB();
                                        break;
                                    case 3:
                                        nxbController.updateNhaXuatBan();
                                        MenuNXB();
                                        break;
                                    case 4:
                                        nxbController.getListNXB();
                                        MenuNXB();
                                        break;
                                    case 0:
                                        System.out.println("Thoát Menu NXB\n");
                                        sc.nextLine();
                                        AdminMenu();
                                        break;
                                }
                                break;

                            case 5:
                                MenuUser();
                                break;
                            case 6:
                                 int choiceKeSach = MenuKeSach();
                                 switch (choiceKeSach) {
                                     case 1:
                                         keSachController.addKeSach();
                                         MenuKeSach();
                                         break;
                                     case 2:
                                         keSachController.deleteKeSach();
                                         MenuKeSach();
                                         break;
                                     case 3:
                                         keSachController.updateKeSach();
                                         MenuKeSach();
                                         break;
                                     case 4:
                                         keSachController.getListKeSach();
                                         MenuKeSach();
                                         break;
                                     case 0:
                                         System.out.println("Thoát Menu KeSach\n");
                                         sc.nextLine();
                                         AdminMenu();
                                         break;

                                 }
                                 break;
                            case 7:
                                phieuPhatController.issueFine();
                                MenuUser();
                                break;

                            case 0:
                                AdminLogged = false;
                                break;
                        }
                    }
                }
                else if ("login failed".equals(Logged)){
                    System.out.println("Sai username hoặc password! Vui lòng thử lại.\n");
                }
                else {
                    boolean UserLogged = true;
                    while (UserLogged) {
                        userController.display_fullname_address(Logged);
                        int UserChoice = UserMenu();
                        switch (UserChoice) {
                            case 1:
                                System.out.println("1 Sửa thông tin cá nhân");
                                userController.updateUser(Logged);
                                break;
                            case 2:
                                /**/;
                            case 3 :
                                /**/;
                            case 4:
                                System.out.println("4 mượn sách");
                                phieuMuonController.borrowBook();
                                break;
                            case 5:
                                System.out.println("5 trả sách");
                                phieuTraController.returnBook();
                                break;
                            case 0:
                                UserLogged = false;
                                break;

                        }
                    }
                }
            }
            else if (choice0 == 2) {
                userController.signup();
            }
            else {
                System.out.println("Lỗi\n");

            }

        }while ( choice0 != 5);
    }
}