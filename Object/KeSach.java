package Object;

public class KeSach {
    public int MaKe;
    public String TenKe;
    public String TrangThai;
    public int IdTag;
    public int ViTri;

    public KeSach(int MaKe,String TenKe, String TrangThai,int IdTag, int ViTri){
        this.MaKe = MaKe;
        this.TenKe = TenKe;
        this.TrangThai = TrangThai;
        this.IdTag = IdTag;
        this.ViTri = ViTri;

    }

    public int getMaKe() {

        return MaKe;
    }

    public String getTenKe() {
        return TenKe;
    }

    public String getTrangThai() {

        return TrangThai;
    }


    public int getIdTag() {
        return IdTag;
    }

    public int getViTri() {

        return ViTri;
    }

    @Override
    public  String toString() {
        return String.format("%-12d %-30s %-10d %-10s %.2f%n", MaKe,TenKe,TrangThai,ViTri,IdTag);
    }
}
