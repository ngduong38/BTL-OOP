package Control;

import DBHandler.DBAuthorHandler;
import Object.Author;
import Validator.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;


public class AuthorController {
    private Scanner sc = new Scanner(System.in);
    private DBAuthorHandler handler = new DBAuthorHandler();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            .withResolverStyle(ResolverStyle.STRICT);

    public void addAuthor() {
        System.out.println("Enter the idAuthor: ");
        int idAuthor = sc.nextInt();
        System.out.println("Enter the Author's name: ");
        sc.nextLine();
        String nameAuthor = sc.nextLine();
        System.out.println("Enter the Author's birthday: ");
        String input = sc.nextLine();
        LocalDate birthday = null;
        while (true) {
            try {
                birthday = LocalDate.parse(input,formatter);
                if (Validator.isValideDate(birthday)) {
                    break; // OK rồi, thoát khỏi vòng lặp
                } else {
                    System.out.println("Sinh nhat khong hop le");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Dinh dang ngay sinh khong hop le (yyyy-MM-dd)");
            }
            input = sc.nextLine();
        }
        System.out.println("Enter the most popular book: ");
        String popular = sc.nextLine();

        Author author = new Author(idAuthor, nameAuthor, birthday, popular);

        if (handler.insertAuthor(author)) {
            System.out.println("Book added");
        } else {
            System.out.println("failed to add book");
        }

    }

    public void deleteAuthor() {
        System.out.println("Enter the idAuthor: ");
        int idAuthor = this.sc.nextInt();
        if (handler.deleteAuthor(idAuthor)) {
            System.out.println("Author " + idAuthor + " deleted");
        } else {
            System.out.println("failed to delete author");
        }

    }

    public void updateAuthor() {
        System.out.println("Enter the author of the book: ");
        int idAthor = this.sc.nextInt();
        Author author = handler.getAuthor(idAthor);
        if (author == null) {
            System.out.println("No such book exists with id " + idAthor);
        } else {
            System.out.println("Author ID: " + author.idAuthor);
            System.out.println("Author name: " + author.nameAuthor);
            System.out.println("Author birthday: " + author.birthday);
            System.out.println("Author tag: " + author.popularBook);

            System.out.println("enter new author name: ");
            this.sc.nextLine();
            String newName = this.sc.nextLine();
            System.out.println("enter new birthday: ");
            String input = this.sc.nextLine();
            LocalDate newBirthday = null;
            while (true) {
                try {
                    newBirthday = LocalDate.parse(input,formatter);
                    if (Validator.isValideDate(newBirthday)) {
                        break; // OK rồi, thoát khỏi vòng lặp
                    } else {
                        System.out.println("Sinh nhat khong hop le");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Dinh dang ngay sinh khong hop le (yyyy-MM-dd)");
                }
                input = sc.nextLine();
            }
            System.out.println("enter new popular book: ");
            String newPopularBook = this.sc.nextLine();
            author.nameAuthor = newName;
            author.birthday = newBirthday;
            author.popularBook = newPopularBook;
            if (handler.updateAuthor(author)) {
                System.out.println("Author updated");
            } else {
                System.out.println("failed to update Author");
            }

        }
    }

    public void getListAuthor() {
        ArrayList<Author> authors = handler.getAllAuthor();
        System.out.printf("%-5s %-25s %-20s %-10s\n", "idAuthor", "authorName", "Birthday","Popularity");
        System.out.println("------------------------------------------------------");

        for(Author author : authors) {
            System.out.printf("%-5d %-25s %-20s %-10s\n", author.idAuthor, author.nameAuthor, author.birthday, author.popularBook);
        }

    }
}
