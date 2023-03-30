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
        UI.addButton("Add Book", this::addBookGUI);
    }

    public void addBookGUI(){
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
        Library.addBook(title, author, quantity, imgFileName);
    }
}
