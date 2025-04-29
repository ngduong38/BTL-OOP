package Feature;

import java.sql.Date;

public class PhieuPhat {
    private int mapp;
    private String fullname;
    private Date ngaymuon;
    private Date ngaytra;
    private double tien;

    public PhieuPhat (int mapp,String fullname,Date ngaymuon,Date ngaytra, double tien){
        this.mapp = mapp;
        this.fullname = fullname;
        this.ngaytra = ngaytra;
        this.ngaymuon = ngaymuon;
        this.tien = tien;
    }

    public int getMapp() {
        return mapp;
    }

    public String getFullname() {
        return fullname;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }
    public Date getNgaytra(){
        return ngaytra;
    }

    public double getTien() {
        return tien;
    }
}
