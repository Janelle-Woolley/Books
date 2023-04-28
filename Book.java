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
    private static final String DEFAULT = "book_cover.jpg";
    
    private int locX = 100;
    private int locY = 100;
    private final double WIDTH = 100;
    private final double HEIGHT = 100;
        
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
     * Display image on GUI
     */
    public void displayBook(){
        UI.drawImage(this.image, this.locX, this.locY, this.WIDTH, this.HEIGHT);
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
    
    /**
     * Getter for author
     * @return the author of book
     */
    public String getTitle(){
        return this.title;
    }
    
    /**
     * Getter for book cover
     * @return the image of book
     */
    public String getImage(){
        return this.image;
    }
    
    /**
     * sees if x, y pos is on the book image
     */
    public boolean onBook(double x, double y){
        if((x>=locX) && (x<=locX+WIDTH) && (y>=locY) && (y<=locY+HEIGHT)){
            return true;
        } else {
            return false;
        }
    }
}
