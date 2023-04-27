import ecs100.*;
/**
 * Class to handle GUI functios
 *
 * @author Janelle Woolley
 * @version 1.0 28/03/23
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private Library books;
    private Book book; // stores the current book instance

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
        UI.addButton("Remove Book", this::deleteBook);
        UI.addButton("Find Book", this::findBook);
        UI.addButton("Print Books", this::printBooks);
        UI.addButton("Clear", this::clearAll);
        
        UI.setMouseListener(this::doMouse);
    }
    
    /**
     * clears text and graphics panes
     */
    public void clearAll(){
        UI.clearText();
        UI.clearGraphics();
        book = null;
    }
    
    public void addBook(){
        final int MAX_QUANTITY = 999;
        final int MIN_QUANTITY = 0;
        
        String title = UI.askString("Enter the book title: ");
        String author = UI.askString("Enter the author: ");
        
        boolean getQty = true;
        int quantity = UI.askInt("Enter Quantity: ");
        while (getQty){
            if (quantity > MAX_QUANTITY || quantity < MIN_QUANTITY){
                quantity = UI.askInt("Enter Quantity (Between 1-999): ");
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
        if(books.findBook(bookName.toLowerCase())){
            UI.println("Found book!");
            book = books.getBook();
            book.displayBook(); // Shows book cover
        } else {
            UI.println("Book not Found");
        }
    }
    
    /**
     * mouse listener
     */
    private void doMouse(String action, double x, double y){
        if (action.equals("clicked")){
            if (book != null){
                if(book.onBook(x, y)){
                    UI.println("---------------------");
                    UI.println("Title: " + book.getTitle());
                    UI.println("Author: " + book.getAuthor());
                    UI.println("Quantity: " + book.getQuantity());
                    UI.println("---------------------");
                }
            }
        }
    }
    
    /**
     * calls method from library that prints all books
     */
    public void printBooks(){
        books.printAll();
    }
    
    /**
     * lets user select a book to delete
     */
    public void deleteBook(){
        String bookName = UI.askString("Name of book to Remove: ");
        if(books.findBook(bookName.toLowerCase())){
            UI.println("Found book!");
            book = books.getBook();
            books.removeBook(bookName);
            UI.println("Book Burnt!");
        } else {
            UI.println("Book not Found");
        }
    }
}