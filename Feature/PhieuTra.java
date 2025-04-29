package Feature;
import java.sql.Date;

public class PhieuTra {
    private int mapt;
    private int idtk;
    private String title;
    private Date ngaytra;
    private String trangthaibook;

    public PhieuTra(int mapt, int idtk, String title, Date ngaytra, String trangthaibook) {
        this.mapt = mapt;
        this.idtk = idtk;
        this.title = title;
        this.ngaytra = ngaytra;
        this.trangthaibook = trangthaibook;
    }

    // Getters & Setters
    public int getMapt() {
        return mapt;
    }


    public int getIdtk() {
        return idtk;
    }


    public String getTitle() {
        return title;
    }

    public Date getNgaytra() {
        return ngaytra;
    }


    public String getTrangthaibook() {
        return trangthaibook;
    }

}
