import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<BorrowRecord> borrowedBooks;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    // Method for the member to borrow a book
    public void borrowBook(Book book, String borrowDate) {
        BorrowRecord record = new BorrowRecord(book, this, borrowDate, null);
        borrowedBooks.add(record);
    }

    // Method for the member to return a book
    public void returnBook(Book book, String returnDate) {
        for (BorrowRecord record : borrowedBooks) {
            if (record.getBook().equals(book) && record.getReturnDate() == null) {
                record.setReturnDate(returnDate);
                break;
            }
        }
    }

    // Method to get borrow date for a specific book
    public String getBorrowDate(Book book) {
        for (BorrowRecord record : borrowedBooks) {
            if (record.getBook().equals(book)) {
                return record.getBorrowDate();
            }
        }
        return null;
    }

    // Method to get return date for a specific book
    public String getReturnDate(Book book) {
        for (BorrowRecord record : borrowedBooks) {
            if (record.getBook().equals(book)) {
                return record.getReturnDate();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name + " (" + memberId + ")";
    }
}
