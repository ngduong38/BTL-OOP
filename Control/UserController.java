package Control;

import DBHandler.DBUserHandler;

import java.util.Scanner;
import Object.User;

public class UserController {
    private Scanner sc = new Scanner(System.in);
    private DBUserHandler handler = new DBUserHandler();

    public void signup() {
        System.out.println("Enter your username: ");
        String UserName = sc.nextLine();
        System.out.println("Enter your password: ");
        String PassWord = sc.nextLine();
        System.out.println("Enter your full name: ");
        String FullName = sc.nextLine();
        System.out.println("Enter your age: ");
        int Age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your address: ");
        String Address = sc.nextLine();
        System.out.println("Enter your phone number: ");
        int PhoneNumber = sc.nextInt();

        User user = new User(UserName, DBUserHandler.passwordHash(PassWord),FullName,Age,PhoneNumber,Address);
        if (handler.insertUser(user)) {
            System.out.println("Dang ky thanh cong");
        } else {
            System.out.println("Dang ky that bai");
        }
    }

    public String login() {
        System.out.println("Enter your username: ");
        String UserName = sc.nextLine();
        System.out.println("Enter your password: ");
        String PassWord = sc.nextLine();

        if(UserName.equals("admin") && PassWord.equals("admin")){
            return "admin";
        }
        String hashedpassword=handler.get_hashedpassword(UserName); //hashedpassword trong database
        if(DBUserHandler.passwordHash(PassWord).equals(hashedpassword)){
            return UserName;
        } else{
            return "login failed";
        }
    }

    public void updateUser(String username){
        System.out.println("Enter your new full name: ");
        String fullName = sc.nextLine();
        System.out.println("Enter your new age: ");
        int age = sc.nextInt();
        System.out.println("Enter your new phone number: ");
        int phoneNumber = sc.nextInt();
        System.out.println("Enter your new address: ");
        sc.nextLine();String address = sc.nextLine();

        if(handler.updateUser(fullName,age,phoneNumber,address,username)){
            System.out.println("User updated");
        }else{
            System.out.println("failed to update user");
        }
    }

    public void display_fullname_address(String username){
        User user = handler.getUser(username);
        System.out.println("Xin chào:"+(user.idTk+1)+"-"+user.FullName+"-"+user.Address);
    }
}
