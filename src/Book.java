// The Book class represents a book in the library
public class Book {
    private String title;  // Book Title
    private String author; // Book Author
    private String isbn;   // Book ISBN number

    // Constructor to initialize a new book
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters and setters for the book's attributes
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // toString method to provide a string representation of the book
    @Override
    public String toString() {
        return title + " by " + author;
    }
}
