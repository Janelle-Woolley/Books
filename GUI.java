import ecs100.*;
import java.util.Scanner;
/**
 * Class to handle GUI functions.
 *
 * @author Janelle Woolley
 * @version 1.0 28/03/23
 */

public class GUI {
  // instance variables - replace the example below with your own
  private Library books;
  private Book book; // stores the current book instance

  /**
   * Constructor for objects of class GUI.
   */
  public GUI() {
    // initialise instance variables
    books = new Library();
    UI.initialise();
    UI.addButton("Quit", UI::quit);
    UI.addButton("Add Book", this::addBook);
    UI.addButton("Remove Book", this::deleteBook);
    UI.addButton("Find Book", this::findBook);
    UI.addButton("Print Books Info", this::printBooks);
    UI.addButton("Edit Quantity", this::editQuantity);
    UI.addButton("Clear", this::clearAll);
        
    UI.setMouseListener(this::doMouse);
  }
    
  /**
   * clears text and graphics panes.
   */
  public void clearAll() {
    UI.clearText();
    UI.clearGraphics();
    book = null;
  }
   
  /**
   * ask user for inputs and adds book to hashmap.
   */
  public void addBook() {
    String title = addTitle();
    String author = addAuth();
    int quantity = addQty();
    String imgFileName = addImg();
    books.addBook(title, author, quantity, imgFileName);
  }
  
  /**
   * ask user to select img file input
   */
  public String addImg() {
    UI.println("Select a book cover");
    String imgFileName = UIFileChooser.open("Choose Image File: ");
    return imgFileName;
  }
  
  /**
   * ask user for title input
   */
  public String addTitle() {
    boolean getTitle = true;
    String title = UI.askString("Enter the book title: ");
    while (getTitle) {
      if (title.equals("")) {
        title = UI.askString("Enter the book title: ");
      } else {
        getTitle = false;
      }
    }
    return title;
  }
  
  /**
   * asks user for authour input
   */
  public String addAuth() {
    boolean getAuthor = true;
    String author = UI.askString("Enter the author: ");
    while (getAuthor) {
      if (author.equals("")) {
        author = UI.askString("Enter the author: ");
      } else {
        getAuthor = false;
      }
    }
    return author;
  }
  
  /**
   * ask user for quantity input
   */
  public int addQty() {
    final int MAX_QUANTITY = 999;
    final int MIN_QUANTITY = 0;
    
    boolean getQty = true;
    int quantity = UI.askInt("Enter Quantity: ");
    while (getQty) {
      if (quantity > MAX_QUANTITY || quantity < MIN_QUANTITY) {
        quantity = UI.askInt("Enter Quantity (Between 1-999): ");
      } else {
        getQty = false;
      }
    }
    return quantity;
  }
  
  /**
   * finds book based on name.
   * prints out author, qty, book cover if found
   */
  public void findBook() {
    String bookName = UI.askString("Name of book: ");
    if (books.findBook(bookName.toLowerCase())) {
      UI.println("Found book!");
      book = books.getBook();
      book.displayBook(); // Shows book cover
    } else {
      UI.println("Book not Found");
    }
  }
    
  /**
   * mouse listener.
   */
  private void doMouse(String action, double x, double y) {
    if (action.equals("clicked")) {
      if (book != null) {
        if (book.onBook(x, y)) {
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
   * calls method from library that prints all books.
   */
  public void printBooks() {
    books.printAll();
  }
    
  /**
   * lets user select a book to delete.
   */
  public void deleteBook() {
    String bookName = UI.askString("Name of book to Remove: ");
    if (books.findBook(bookName.toLowerCase())) {
      UI.println("Found book!");
      book = books.getBook();
      books.removeBook(bookName);
      UI.println("Book Burnt!");
    } else {
      UI.println("Book not Found");
    }
  }
    
  /**
   * removes book and re-adds it with changed quantity.
   */
  public void editQuantity() {
    String bookName = UI.askString("Name of book to edit quantity: ");
    if (books.findBook(bookName.toLowerCase())) {
      UI.println("Found book!");
      book = books.getBook();
            
      // ask for new quantity
      final int MAX_QUANTITY = 999;
      final int MIN_QUANTITY = 0;
      boolean getQty = true;
      int quantity = UI.askInt("Enter Quantity: ");
      while (getQty) {
        if (quantity > MAX_QUANTITY || quantity < MIN_QUANTITY) {
          quantity = UI.askInt("Enter Quantity (Between 1-999): ");
        } else if (quantity == book.getQuantity()) {
          UI.println("That is the old quantity");
          quantity = UI.askInt("Enter a NEW Quantity: ");
        } else {
          getQty = false;
        }
      }
            
      // get book info
      String title = book.getTitle();
      String author = book.getAuthor();
      String image = book.getImage();
      // remove book
      books.removeBook(bookName);
      // add book with new quantity
      books.addBook(title, author, quantity, image);
    } else {
      UI.println("Book not Found");
    }
  }
    
  /**
   * puts images into an array and prints them out.
   */
  public void displayAll() {
    String[][] bookCovers;
        
    for (int bk = 0; bk < books.getSize(); bk++) {
            
    }
  }
}