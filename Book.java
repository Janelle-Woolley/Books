import ecs100.*;
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
    
    /**
     * Getter for name
     * @return the name of book
     */
    public String getName(){
        return this.title;
    }
    
    /**
     * Display image on GUI
     */
    public void displayBook(){
        int locX = 100;
        int locY = 100;
        final double WIDTH = 100;
        final double HEIGHT = 100;
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
    
    /**
     * Getter for author
     * @return the author of book
     */
    public String getAuthor(){
        return this.author;
    }
    
    /**
     * Getter for Quantity
     * @return the Quantity of book
     */
    public int getQuantity(){
        return this.quantity;
    }
}
