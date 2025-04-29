package Object;

public class TheLoai {
    public int idTag;
    public String tentheloaisach;
    public String description;


    public TheLoai(int idTag, String tentheloaisach, String description) {
        this.idTag = idTag;
        this.tentheloaisach = tentheloaisach;
        this.description = description;

    }
    public String toString(){
        return "idTag: "+ idTag+ "tentheloaisach: " + tentheloaisach + "description: " + description ;
    }
}
