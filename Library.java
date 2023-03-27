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
    private HashMap<String, Book> bookShelf;
    private final int MAXBOOKS = 3;    
    private int id = 0;
    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        // initialise instance variables
        bookShelf = new HashMap<String, Book>();
        
        UI.addButton("Quit", UI::quit);
        UI.addButton("Add Book", this::addValues);
        UI.addButton("Print Books", this::printValues);
    }

    public void addValues(){
        id++;
        String title, author, genre;
        int pages;
        title = UI.askString("Enter the book title: ");
        author = UI.askString("Enter the author: ");
        int published = UI.askInt("Enter date published: ");
        pages = UI.askInt("Enter the page count: ");
        genre = UI.askString("Enter genre: ");
        image =;
        
        Book book1 = new Book(id, title, author, published, pages, genre, image);
        bookShelf.put(title, book1);
    }
    
    public void printValues(){
        for (String title : bookShelf.keySet()){
            UI.println(bookShelf.get(title));
        }
    }
}
