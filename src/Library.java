import java.util.Scanner;
import java.util.ArrayList;
public class Library {
ArrayList <Book> list_books = new ArrayList<>();
ArrayList <User> list_users = new ArrayList<>();
Scanner input = new Scanner(System.in);
public void add_book(){

    System.out.println("Enter the Book ID: ");
    String book_id = input.nextLine();
    System.out.println("Enter the Book title: ");
    String title = input.nextLine();
    System.out.println("Enter the Book's Author: ");
    String author= input.nextLine();
    System.out.println("Enter the Book's genre: ");
    String genre = input.nextLine();
    Book b = new Book(book_id,title,author,genre);
    list_books.add(b);
}
public void add_user(){
    int userid = input.nextInt();
    String name = input.nextLine();
    String contact = input.nextLine();
    User u = new User(userid,name,contact);
    list_users.add(u);
}
}
