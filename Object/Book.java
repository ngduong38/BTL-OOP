package Object;

public class Book
{
    public int idbook;
    public int idTag;
    public int idAuthor;
    public int maNXB;
    public String title;
    public int soluong;


    public Book(int idbook,int idTag,int idAuthor,int maNXB,String title,int soluong) {
        this.idbook = idbook;
        this.idTag = idTag;
        this.idAuthor = idAuthor;
        this.maNXB = maNXB;
        this.soluong = soluong;
        this.title = title;
    }
    public String toString(){ return "idbook "+idbook + "idTag " + idTag + "idAuthor " + idAuthor + "maNXB " + maNXB+ "title " + title + "soluong " + soluong ; }

}
