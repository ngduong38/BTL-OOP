package Object;

public class User {
    public int idTk;
    public String UserName;
    public String PassWord;
    public String FullName;
    public int Tuoi;
    public int PhoneNumber;
    public String Address;

    public User(String UserName, String PassWord,String FullName,int Tuoi, int PhoneNumber,String Address) {

        this.UserName = UserName;
        this.PassWord = PassWord;
        this.FullName = FullName;
        this.Tuoi = Tuoi;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
    }

    public int getIdTk() {
        return idTk;
    }

    public String getUserName(){
        return UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getFullName() {
        return FullName;
    }

    public String getAddress() {
        return Address;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public int getTuoi() {
        return Tuoi;
    }

    @Override
    public  String toString() {
        return String.format("%-12d %-30s %-10d %.2f%n",idTk,PassWord,FullName,Address,Tuoi,PhoneNumber );
    }
}
