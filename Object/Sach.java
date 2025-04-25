package Object;

public class Sach {
    private int MaSach;
    private String TenSach;
    private int MaLoai;
    private int MaNXB;
    private int MaTacgia;
    private int Namxb;
    private int Soluong;
    private int Make;
    private int TrangThai;


    public Sach(int MaSach, String TenSach, int Maloai, int MaNXB, int Matacgia,
                int Namxb, int Soluong,int Make, int TrangThai){
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.MaLoai = Maloai;
        this.MaNXB = MaNXB;
        this.MaTacgia = Matacgia;
        this.Namxb = Namxb;
        this.Soluong = Soluong;
        this.Make = Make;
        this.TrangThai = TrangThai;
    }

    public int getMaSach() {
        return MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public int getMaNXB() {
        return MaNXB;
    }

    public int getMaTacgia() {
        return MaTacgia;
    }

    public int getNamxb() {
        return Namxb;
    }

    public int getSoluong() {
        return Soluong;
    }

    public int getMake() {
        return Make;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTenSach(String tenSach) {
        this.TenSach = tenSach;
    }

    public void setMaLoai(int maLoai) {
        this.MaLoai = maLoai;
    }

    public void setMaNXB(int maNXB) {
        this.MaNXB = maNXB;
    }

    public void setMaTacgia(int maTacgia) {
        this.MaTacgia = maTacgia;
    }

    public void setNamxb(int namxb) {
        this.Namxb = namxb;
    }

    public void setMaSach(int maSach) {
        this.MaSach = maSach;
    }

    public void setSoluong(int soluong) {
        this.Soluong = soluong;
    }

    public void setMake(int make) {
        this.Make = make;
    }

    public void setTrangThai(int trangThai) {
        this.TrangThai = trangThai;
    }

    @Override
    public  String toString() {
        return String.format("%-12d %-30s %-10d %.2f%n", MaSach,TenSach,MaLoai,MaNXB,MaTacgia,Namxb,Soluong,Make,TrangThai);
    }
}
