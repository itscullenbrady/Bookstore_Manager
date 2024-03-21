import java.util.ArrayList;
import java.util.Scanner;

// Main class that serves as the entry point of the program
public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager(); // Create an instance of InventoryManager
        // Adding initial books to the inventory
        manager.addBook("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 7);
        manager.addBook("To Kill a Mockingbird", "Harper Lee", "9780061120084", 20);
        manager.addBook("Critique of Pure Reason", "Immanuel Kant", "9780275836592", 27);
        manager.addBook("1984", "George Orwell", "9780451524935", 15);
        manager.addBook("The Catcher in the Rye", "J.D. Salinger", "9780316769488", 12);

        Scanner scanner = new Scanner(System.in); // Scanner for user input

        boolean running = true;
        while (running) {
            // Displaying the menu options
            System.out.println("Select an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Sell a book");
            System.out.println("4. Generate sales report");
            System.out.println("5. View inventory");
            System.out.println("6. Exit");

            int choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Option to add a new book
                    System.out.println("Enter Title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter Author:");
                    String author = scanner.nextLine();
                    System.out.println("Enter ISBN:");
                    String ISBN = scanner.nextLine();
                    System.out.println("Enter Quantity:");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    manager.addBook(title, author, ISBN, quantity);
                    break;
                case 2: // Option to remove a book
                    System.out.println("Enter ISBN of the book to remove:");
                    String removeISBN = scanner.nextLine();
                    manager.removeBook(removeISBN);
                    break;
                case 3: // Option to sell a book
                    System.out.println("Enter the ISBN of the book to sell:");
                    String sellISBN = scanner.nextLine();
                    System.out.println("Enter the quantity to sell:");
                    int sellQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    manager.sellBook(sellISBN, sellQuantity);
                    break;
                case 4: // Option to generate a sales report
                    manager.generateSalesReport();
                    break;
                case 5: // Option to view the inventory
                    manager.displayInventory();
                    break;
                case 6: // Exit the program
                    running = false;
                    break;
                default: // Handling invalid choices
                    System.out.println("Invalid choice. Please enter a number between 1-6.");
                    break;
            }
        }

        scanner.close(); // Closing the scanner
    }
}

// Book class representing the attributes and behavior of a book
class Book {
    private String title;
    private String author;
    private String ISBN;
    private int quantity;
    private int initialQuantity;

    // Constructor to initialize the book attributes
    public Book(String title, String author, String ISBN, int quantity) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.quantity = quantity;
        this.initialQuantity = quantity;
    }

    // Getters for book attributes
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    // Overriding toString method to display book information
    @Override
    public String toString() {
        return "------------------------\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "ISBN: " + ISBN + "\n" +
                "Quantity: " + quantity +
                "\n------------------------";
    }
}

// InventoryManager class to manage the book inventory
class InventoryManager {
    private ArrayList<Book> inventory; // ArrayList to store books in the inventory

    // Constructor to initialize the inventory
    public InventoryManager() {
        inventory = new ArrayList<>();
    }

    // Method to add a new book to the inventory
    public void addBook(String title, String author, String ISBN, int quantity) {
        Book newBook = new Book(title, author, ISBN, quantity);
        inventory.add(newBook);
        System.out.println("Book added to inventory: " + title);
    }

    // Method to remove a book from the inventory based on its ISBN
    public void removeBook(String ISBN) {
        for (Book book : inventory) {
            if (book.getISBN().equals(ISBN)) {
                inventory.remove(book);
                System.out.println("Book removed from inventory: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found.");
    }

    // Method to sell a specified quantity of a book based on its ISBN
    public void sellBook(String ISBN, int quantityToSell) {
        boolean found = false;
        for (Book book : inventory) {
            if (book.getISBN().equals(ISBN)) {
                found = true;
                if (book.getQuantity() >= quantityToSell) {
                    book.setQuantity(book.getQuantity() - quantityToSell);
                    System.out.println("Sold " + quantityToSell + " copies of " + book.getTitle());
                } else {
                    System.out.println("Insufficient stock for " + book.getTitle());
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Book with ISBN " + ISBN + " not found.");
        }
    }

    // Method to generate a sales report displaying sold quantities and remaining stock
    public void generateSalesReport() {
        int totalSold = 0;
        System.out.println("Sales Report:");
        for (Book book : inventory) {
            int initialQuantity = book.getInitialQuantity();
            int sold = initialQuantity - book.getQuantity(); // Calculate the quantity sold
            totalSold += sold;
            System.out.println("Book: " + book.getTitle() + ", Total Sold: " + sold + ", Remaining Stock: " + book.getQuantity());
        }
        System.out.println("Total Quantity Sold: " + totalSold);
    }

    // Method to display the current inventory
    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Book book : inventory) {
            System.out.println(book.toString());
        }
    }
}
