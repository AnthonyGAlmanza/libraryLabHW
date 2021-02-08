package libraryLabProject;

import java.util.HashMap;
import java.util.Map;

public class Library{
	
	
	// Instance variables
	public String location;
	public String title;
	private HashMap<String, Book> books;
	
	
	// Constructors
	public Library(){
		books = new HashMap<String, Book>();
	}
	
	public Library(String loc) {
		location = loc;
		books = new HashMap<String, Book>();
	}
	
	// Methods
	public void addBook(Book b) {
		books.put(b.title, b);
	}
	
	public void borrowBook(String title) {
		// check if contains and borrowed is false
		if(books.containsKey(title) && books.get(title).isBorrowed() == false) {
			// borrow the book
			books.get(title).borrowed();
			// print something
			System.out.println("You successfully borrowed " + title);
		}
		// check if contains and borrowed is true
		else if(books.containsKey(title) && books.get(title).isBorrowed() == true) {
			// don't borrow
			
			// print something
			System.out.println("Sorry, this book is already borrowed.");
		}
		// that it doesn't contain and returns not in catalog
		if(!books.containsKey(title)) {
			// print something
			System.out.println("Sorry, this book is not in our catalog.");
		}		
	}
	
	public void returnBook(String title) {
		// check if borrowed
		if(books.containsKey(title) && books.get(title).isBorrowed() == true) {
			//return the book
			books.get(title).returned();
			System.out.println("You successfully returned " + title);
		}
	}
	
	public void printAvailableBooks() {
		// look through all the books
		if (books.isEmpty()) {
			System.out.println("No book in catalog");
		}
		for(Map.Entry titleAndBook : books.entrySet()) {
			Book book = (Book)titleAndBook.getValue();
			if(!book.isBorrowed()) {
				System.out.println(book.getTitle());
			}
		}
	}
	
	public static void printOpeningHours() {
		System.out.println("Libraries are open from 9 AM to 5 PM daily");
	}
	
	public void printAddress() {
		 System.out.println(location);
	}
	
	

	public static void main(String[] args) {
		
		// Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();

	}

}
