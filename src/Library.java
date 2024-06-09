import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<HistoryEvent> history;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        history = new ArrayList<>();
    }

    // Method to add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        history.add(new HistoryEvent("Add Book", "Added book: " + book.getTitle()));
    }

    // Method to register a new member in the library
    public void registerMember(Member member) {
        members.add(member);
        history.add(new HistoryEvent("Add Member", "Added member: " + member.getName()));
    }

    // Method for a member to borrow a book from the library
    public void lendBook(Book book, Member member, String borrowDate) {
        if (books.contains(book) && members.contains(member)) {
            member.borrowBook(book, borrowDate);
            history.add(new HistoryEvent("Member Name:", member.getName() + " Borrowed Book Title: " + book.getTitle() + " Date: " + borrowDate));
        }
    }

    // Method for a member to return a book to the library
    public void returnBook(Book book, Member member, String returnDate) {
        if (members.contains(member)) {
            member.returnBook(book, returnDate);
            history.add(new HistoryEvent("Member Name:", member.getName() + " Returned Book Title: " + book.getTitle() + " Date:" + returnDate));
        }
    }

     // Method to find a member by ID
     public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null; // Member not found
    }

    // Method to find a member by name
    public Member findMemberByName(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null; // Member not found
    }

    // Method to find a book by ISBN
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Method to find a book by title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Method to find books by author
    public List<Book> findBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    // Method to retrieve and display the history of events
    public void displayHistory() {
        System.out.println("Library History:");
        for (HistoryEvent event : history) {
            System.out.println(event.getEventType() + ": " + event.getDescription());
        }
    }

    
}
