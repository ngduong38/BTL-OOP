package Object;

import java.time.LocalDate;
import java.util.Date;


public class Author {
    public int idAuthor;
    public String nameAuthor;
    public LocalDate birthday;
    public String popularBook;

    public Author(int idAuthor,String nameAuthor, LocalDate birthday, String popularBook) {
        this.idAuthor = idAuthor;
        this.nameAuthor = nameAuthor;
        this.birthday = birthday;
        this.popularBook = popularBook;
    }




    public String toString(){
        return "idAuthor: "+ idAuthor+ "nameAuthor: " + nameAuthor + "birthday: " + birthday + "popular: " + popularBook;
    }
}
