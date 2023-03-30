
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
    private String title;
    private String author;
    private int quantity;
    private String image;
    private static final String DEFAULT = "default_book.jpg";
    /**
     * Constructor for objects of class Book
     */
    public Book(String name, String auth, int qty, String img)
    {
        // initialise instance variables
        this.title = name;
        this.author = auth;
        this.quantity = qty;
        
        // if the user selects cancel instead of giving image
        if (img == null){
            this.image = DEFAULT;
        } else {
            this.image = img;
        }
    }
    
    /**
     * Constructor overloading for objects of class Book
     */
    public Book(String name, String auth, int qty)
    {
        // initialise instance variables
        this(name, auth, qty, null);
    }
}
