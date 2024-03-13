import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class Library {

    private ArrayList<Book> list_books;
    private ArrayList<User> list_users;
    private Scanner input;

    // Constructor
    public Library() {
        list_books = new ArrayList<>();
        list_users = new ArrayList<>();
        input = new Scanner(System.in);
        // Load data from files
        loadBooks();
        loadUsers();
        }

       //method for file handling
        private void saveBooks() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.ser"))) {
                oos.writeObject(list_books);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // method to load the stored data
        private void loadBooks() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.ser"))) {
                list_books = (ArrayList<Book>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // method to save the user data
        private void saveUsers() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.ser"))) {
                oos.writeObject(list_users);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // method to load the user data
        private void loadUsers() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.ser"))) {
                list_users = (ArrayList<User>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        // Method to exit the program and save data to files
        public void exit() {
            saveBooks();
            saveUsers();
            System.out.println("Exiting the program. Data saved successfully.");
        }
    //method to add book and take user input for book detail
    public void add_book() {
        try {
            System.out.println("Enter the Book ID: ");
            String book_id;
            //error handling to ensure no book is added with same id
            while(true){
                book_id = input.nextLine();
                boolean id_exist = false;
                for( Book book:list_books){
                    if (book.bookid.equals(book_id)) {
                        id_exist = true;
                        break;
                    }
                }
                if(!id_exist){
                    break;
                }
                else{
                    System.out.println("Book id already exit try another one.");
                }
            }
            System.out.println("Enter the Book title: ");
            String title = input.nextLine();
            System.out.println("Enter the Book's Author: ");
            String author = input.nextLine();
            System.out.println("Enter the Book's genre: ");
            String genre = input.nextLine();

            // Validate input
            if (book_id.isEmpty() || title.isEmpty() || author.isEmpty() || genre.isEmpty()) {
                System.out.println("Error: All fields must be filled.");
                return;
            }

            Book b = new Book(book_id, title, author, genre);
            b.bookavalibilty = true;
            list_books.add(b);
            System.out.println("Book is successfully added.");
        } catch (Exception e) {
            System.out.println("Error occurred while adding book: " + e.getMessage());
        }
    }
    //method to add user take user input for user information
    public void add_user() {
        try {
            int userid;
            System.out.println("Enter the User ID :");
            while(true){
                boolean id_exits = false ;
                userid = input.nextInt();
                for(User user: list_users){
                if(user.userid==userid){
                    id_exits = true;
                    break;
                }
            }
            if(!id_exits) {
                break;
            }
            else{
                System.out.println("User ID exits try another one");
            }
            }
            input.nextLine();
            System.out.println("Enter the User Name :");
            String name = input.nextLine();
            System.out.println("Enter the User Contact Number :");
            String contact = input.nextLine();

            // Validate input
            if (name.isEmpty() || contact.isEmpty()) {
                System.out.println("Error: Name and contact number must be provided.");
                return;
            }
            User u = new User(userid, name, contact);
            list_users.add(u);
            System.out.println("User is successfully added.");
        } catch (Exception e) {
            System.out.println("Error occurred while adding user: " + e.getMessage());
        }
    }
    //method to issue book to registered user
    public void checkout_book(){
    System.out.println("Enter User ID: ");
    int user_id = input.nextInt();
    for(int i= 0;i<list_users.size();i++){
        //condition to check if user exists
        if(user_id==list_users.get(i).userid){
            System.out.println("User ID Found. User Name is :"+list_users.get(i).name);
            System.out.println("Enter Book ID to issue: ");
            input.nextLine();
            String book_id = input.nextLine();
            int book_index = search_book(book_id);
            //condition to check if book exists and if book is available
            if(book_index==-1){
                System.out.println("Book not found.");
            }
            else if(!list_books.get(book_index).bookavalibilty){
                System.out.println("Book is unavailable");
            }
            else{
                    System.out.println("Book is found with title " + list_books.get(book_index).title);
                    list_users.get(i).br_books.add(list_books.get(book_index));
                    list_books.get(book_index).bookavalibilty = false;
                    System.out.println("Book id successfully checked out.");
            }
        }
    }


}
    //method to search the book by book id and return the index of book array list
    public int search_book(String book_id){
        int position = -1;
        for(int i = 0;i<list_books.size();i++){
            if(list_books.get(i).bookid.equals(book_id)){
             position = i;
             break;
        }
        }
    return position;
}
//method to return book
public void book_return(){
    System.out.println("Enter the User ID :");
    int user_id = input.nextInt();
    for(int i = 0;i<list_users.size();i++){
        //condition to check if user exists
        if(list_users.get(i).userid==(user_id)){
            System.out.println("User Found with name " + list_users.get(i).name);
            System.out.println("Enter the Book ID you want to return : ");
            input.nextLine();
            String book_id = input.nextLine();
            for(int j = 0; j<list_users.get(i).br_books.size();j++){
                //condition to check if user has borrowed that book
                if(list_users.get(i).br_books.get(j).bookid.equals(book_id)){
                    System.out.println("Book Found in your borrow list!");
                    for(Book book: list_books){
                        if(book.bookid.equals(book_id)){
                            book.bookavalibilty = true;
                        }
                    }
                    //removing book from users borrowed list
                    list_users.get(i).br_books.remove(j);
                    System.out.println("Book successfully returned.");
                }
                else{
                    System.out.println("Book Not found.");
                }
            }
        }
    }
}
    //displaying book information according to the index of array list
    public void display_book(int position){
        System.out.println("Title of the Book is :"+list_books.get(position).title);
        System.out.println("Author of the Book is : "+list_books.get(position).author);
        System.out.println("Genre of the Book is : "+list_books.get(position).genre);
        if(list_books.get(position).bookavalibilty){
            System.out.println("Book is available.");
        }
        else{
            System.out.println("Book is not available");
        }
    }
}
