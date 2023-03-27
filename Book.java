
/**
 * Support class for library
 * Creates books
 *
 * @author Janelle Woolley
 * @version 1.0 27/03/23
 */
public class Book
{
    // instance variables - replace the example below with your own
    private int id;
    private String title;
    private String author;
    private int publishedDate;
    private int pages;
    private String genre;
    private String image;
    
    /**
     * Constructor for objects of class Book
     */
    public Book(int id, String name, String auth, int published, int pg, String type, String img)
    {
        // initialise instance variables
        this.id = id;
        this.title = name;
        this.author = auth;
        this.publishedDate = published;
        this.pages = pg;
        this.genre = type;
        this.image = img;
    }

    /**
     * converts this.Book to a string so it can be printed
     */
    public String toString(){
        return ("Title: " + title + " Author: " + author + " Published: " + publishedDate + " Pages: " + pages + " Genre: " + genre);
    }
}
