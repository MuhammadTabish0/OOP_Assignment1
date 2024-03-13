import java.util.Scanner;
public class Main{
    public static void main(String [] argc){
        Scanner input = new Scanner(System.in);
        Library l = new Library();
        boolean running = true;
        //loop to run the program
        while(running){

            System.out.println("Welcome to My Program");
            System.out.println("Press 1 to add user\nPress 2 to add Book\nPress 3 to issue Book\nPress 4 to return book");
            System.out.println("Press 5 to Search a book");
            System.out.println("Press 6 to quit.");

            int inp = input.nextInt();
            //using switch case for different function call
            switch (inp){
                case 1:
                    l.add_user();
                    break;
                case 2:
                    l.add_book();
                    break;
                case 3:
                    l.checkout_book();
                    break;
                case 4:
                    l.book_return();
                    break;
                case 5:
                    System.out.println("Enter book id: ");
                    input.nextLine();
                    String b_id= input.nextLine();
                    l.display_book(l.search_book(b_id));
                    break;
                case 6:
                    l.exit();
                    running = false;
            }

        }

    }
}