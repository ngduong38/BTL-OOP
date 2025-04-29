package Feature;

import java.sql.Date;

public class PhieuMuon {
    private int mapm;
    private int idtk;
    private String title;
    private Date ngaymuon;
    private Date hantra;

    // Constructor
    public PhieuMuon(int mapm, int idtk, String title, Date ngaymuon, Date hantra) {
        this.mapm = mapm;
        this.idtk = idtk;
        this.title = title;
        this.ngaymuon = ngaymuon;
        this.hantra = hantra;
    }
    public int getMapm() {
        return mapm;
    }
    public void setMapm(int mapm) {
        this.mapm = mapm;
    }

    public int getIdtk() {
        return idtk;
    }

    public String getTitle() {
        return title;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }


    public Date getHantra() {
        return hantra;
    }

}
