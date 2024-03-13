import java.io.Serializable;

public class Book implements Serializable {
    //perimeters
    String bookid;
    String title;
    String author;
    String genre;
    //constructor
    Book(String ebookid,String etitle,String eauthor,String egenre){
        bookid = ebookid;
        title = etitle;
        author = eauthor;
        genre = egenre;
    };

    boolean bookavalibilty;

}
