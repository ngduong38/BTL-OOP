package Object;

public class KeSach {
    public int MaKe;
    public String ViTri;
    public int TrangThai;

    public KeSach(int MaKe, String ViTri, int TrangThai){
        this.MaKe = MaKe;
        this.ViTri = ViTri;
        this.TrangThai = TrangThai;
    }

    public int getMaKe() {
        return MaKe;
    }

    public String getViTri() {
        return ViTri;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setMaKe(int maKe) {
        this.MaKe = maKe;
    }

    public void setViTri(String viTri) {
        this.ViTri = viTri;
    }

    public void setTrangThai(int trangThai) {
        this.TrangThai = trangThai;
    }

    @Override
    public  String toString() {
        return String.format("%-12d %-30s %-10d %.2f%n", MaKe,ViTri,TrangThai);
    }
}
