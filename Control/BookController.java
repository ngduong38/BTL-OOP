package Control;


import Object.Book;
import DBHandler.DBBookHandler;
import java.util.ArrayList;
import java.util.Scanner;

public class BookController {
    private Scanner sc = new Scanner(System.in);
    private DBBookHandler handler = new DBBookHandler();

    public void addBook() {
        System.out.println("Enter the idbook of the book: ");
        int idbook = sc.nextInt();
        System.out.println("Enter the idTag of the book: ");
        int idTag = sc.nextInt();
        System.out.println("Enter the idAuthor of the book: ");
        int idAuthor = sc.nextInt();
        System.out.println("Enter the maNXB of the book: ");
        int maNXB = sc.nextInt();
        System.out.println("Enter the title of the book: ");
        sc.nextLine();
        String title = sc.nextLine();
        System.out.println("Enter the soluong of the book: ");
        int soluong = sc.nextInt();

        Book book = new Book(idbook, idTag, idAuthor, maNXB, title, soluong);

        if (handler.insertBook(book)) {
            System.out.println("Book added");
        } else {
            System.out.println("failed to add book");
        }

    }

    public void deleteBook() {
        System.out.println("Enter the idbook : ");
        int idBook = this.sc.nextInt();
        if (handler.deleteBook(idBook)) {
            System.out.println("Book " + idBook + " deleted");
        } else {
            System.out.println("failed to delete book");
        }

    }

    public void updateBook() {
        System.out.println("Enter the title of the book: ");
        int idBook = this.sc.nextInt();
        Book book = handler.getBook(idBook);
        if (book == null) {
            System.out.println("No such book exists with id " + idBook);
        } else {
            System.out.println("Book ID: " + book.idbook);
            System.out.println("Book idTag: " + book.idTag);
            System.out.println("Book idAuthor: " + book.idAuthor);
            System.out.println("Book maNXB: " + book.maNXB);
            System.out.println("Book soluong: " + book.soluong);
            System.out.println("enter new book's title: ");
            this.sc.nextLine();
            String newTitle= this.sc.nextLine();
            System.out.println("enter new idAuthor: ");
            int newidAuthor = this.sc.nextInt();
            System.out.println("enter new book's idTag: ");
            int newidTag = this.sc.nextInt();
            System.out.println("enter new book's maNXB: ");
            int newmaNXB = this.sc.nextInt();
            System.out.println("enter new book's soluong: ");
            int newsoluong = this.sc.nextInt();
            book.title = newTitle;
            book.idAuthor = newidAuthor;
            book.idTag = newidTag;
            book.maNXB = newmaNXB;
            book.soluong = newsoluong;
            if (handler.updateBook(book)) {
                System.out.println("Book updated");
            } else {
                System.out.println("failed to update book");
            }

        }
    }

    public void getListBooks() {
        ArrayList<Book> books = handler.getAllBooks();
        System.out.printf("%-5s %-25s %-20s %-20s %-20s %-10s\n", "idbook", "idTag", "idAuthor","maNXB","title","soluong");
        System.out.println("------------------------------------------------------");

        for(Book book : books) {
            System.out.printf("%-5d %-25s %-20s %-20s %-20s %-10s\n", book.idbook, book.idTag, book.idAuthor, book.maNXB, book.title, book.soluong);
        }

    }
}
