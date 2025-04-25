package Object;

public class NhaXuatBan {
    public int MaNXB;
    public String TenNXB;
    public String DiaChi;
    public String Sdt;
    public int TrangThai;

    public NhaXuatBan(int MaNXB, String TenNXB, String DiaChi, String Sdt, int TrangThai){
        this.MaNXB = MaNXB;
        this.TenNXB = TenNXB;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.TrangThai = TrangThai;
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

    public int getTrangThai() {
        return TrangThai;
    }

    public void setMaNXB(int maNXB) {
        this.MaNXB = maNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.TenNXB = tenNXB;
    }

    public void setDiaChi(String diaChi) {
        this.DiaChi = diaChi;
    }

    public void setSdt(String sdt) {
        this.Sdt = sdt;
    }

    public void setTrangThai(int trangThai) {
        this.TrangThai = trangThai;
    }

    @Override
    public  String toString() {
        return String.format("%-12d %-30s %-10d %.2f%n", MaNXB,TenNXB,MaNXB,Sdt,TrangThai);
    }
}
