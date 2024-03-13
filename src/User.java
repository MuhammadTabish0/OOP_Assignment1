//file name : src\User.java
import java.io.Serializable;
import java.util.ArrayList;
public class User implements Serializable {
    //user perimeters
    int userid;
    String name;
    String contact;
    User(int euserid,String ename,String econtact){
        userid = euserid;
        name = ename;
        contact = econtact;
    };
    ArrayList <Book> br_books = new ArrayList<Book>();
}

