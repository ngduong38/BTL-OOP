package Validator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;


public class Validator {
    public static boolean isValidPhone(String sdt) {
        return sdt.matches("\\d{10}");
    }

    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z\\s]+");
    }

    public  static boolean isValidTenKeSach(String TenKe ){
        switch (TenKe.toLowerCase()){
            case "sach giao khoa" :

            case "truyen ngu ngon" :

            case "truyen tieu thuyet" :

            case "Truyen kiem hiep":

            case "sach van hoc":
                return true;
            default:
                return false;
        }
    }

    public  static boolean isValidIdTag(int type ){
        switch (type){
            case 1 :
            case 2 :
            case 3 :
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    public static boolean isValideDate(LocalDate birthday){
        if (birthday == null) {
            return false;
        }

        // Kiểm tra năm hợp lệ
        int year = birthday.getYear();
        int currentYear = LocalDate.now().getYear();
        if (year < 1900 || year > currentYear) {
            return false;
        }
        return true;
    }
}
