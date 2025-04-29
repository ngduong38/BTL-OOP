package Object;

public class NhaXuatBan {
    public int MaNXB;
    public String TenNXB;
    public String DiaChi;
    public String Sdt;


    public NhaXuatBan(int MaNXB, String TenNXB, String DiaChi, String Sdt ){
        this.MaNXB = MaNXB;
        this.TenNXB = TenNXB;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
    }

    public int getMaNXB() {
        return MaNXB;
    }

    public String getTenNXB() {
        return TenNXB;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSdt() {
        return Sdt;
    }




    @Override
    public  String toString() {
        return String.format("%-12d %-30s %-10d %.2f%n", MaNXB,TenNXB,DiaChi,Sdt);
    }
}
