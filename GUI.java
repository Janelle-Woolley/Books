import ecs100.*;
/**
 * Class to handle GUI functios
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private Library books;

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        books = new Library();
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        UI.addButton("Add Book", this::addBook);
        UI.addButton("Find Book", this::findBook);
    }

    public void addBook(){
        final int MAX_QUANTITY = 999;
        
        String title = UI.askString("Enter the book title: ");
        String author = UI.askString("Enter the author: ");
        
        boolean getQty = true;
        int quantity = UI.askInt("Enter Quantity: ");
        while (getQty){
            if (quantity > MAX_QUANTITY){
                quantity = UI.askInt("Enter Quantity: ");
            } else{
                getQty = false;
            }
        }
        
        
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        books.addBook(title, author, quantity, imgFileName);
    }
    
    /**
     * finds book based on name
     * prints out author, qty, book cover if found
     */
    public void findBook(){
        String bookName = UI.askString("Name of book: ");
        if(books.findBook(bookName)){
            UI.println("Found book!");
        } else {
            UI.println("Book not Found");
        }
    }
}
