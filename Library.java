import java.util.HashMap;
import ecs100.*;
/**
 * holds collection in hashmap
 * allows user to add books to a hashmap
 * prints out the hashmap
 *
 * @author Janelle Woolley
 * @version 1.0 28/03/23
 */
public class Library
{
    // instance variables - replace the example below with your own
    private HashMap<Integer, Book> bookShelf; // declear the hashmap   
    private int currentId;  // store the current id of the book
    private Book currBook;  // store the instance of the found book
    
    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        // initialise instance variables
        bookShelf = new HashMap<Integer, Book>(); // intailise the hashmap
        
        // create default books
        Book b1 = new Book("Cellphone", "Steven King", 44);
        Book b2 = new Book("Pet Cemetry", "Steven King", 31);
        Book b3 = new Book("1984", "Gorge Orwell", 22);
        
        bookShelf.put(1, b1);
        bookShelf.put(2, b2);
        bookShelf.put(3, b3);
        
        this.currentId = 3;
    }
    
    /**
     * adds book to hashmap
     */
    public void addBook(String nm, String auth, int qty, String img){
        currentId++;
        bookShelf.put(currentId, new Book(nm, auth, qty, img));
    }
    
    /**
     * looks for book in hashmap
     * @return boolean if found
     */
    public boolean findBook(String name) {
        for (int bookId : bookShelf.keySet()) {
            if (bookShelf.get(bookId).getName().toLowerCase().equals(name)){
                currBook = bookShelf.get(bookId);
                return true;
            }
        }
        return false; // if not found
    }
    
    /**
     * getter for current book
     * @return the found book instance
     */
    public Book getBook(){
        return this.currBook;
    }
    
}
