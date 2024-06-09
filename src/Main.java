import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Library Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. Add a new member");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Show history");
            System.out.println("6. Find a member");
            System.out.println("7. Find a book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addNewBook(library, scanner);
                    break;
                case 2:
                    addNewMember(library, scanner);
                    break;
                case 3:
                    borrowBook(library, scanner);
                    break;
                case 4:
                    returnBook(library, scanner);
                    break;
                case 5:
                    showHistory(library);
                    break;
                case 6:
                    findMember(library, scanner);
                    break;
                case 7:
                    findBook(library, scanner);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        } while (choice != 8);

        scanner.close();
    }

    private static void addNewBook(Library library, Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        Book newBook = new Book(title, author, isbn);
        library.addBook(newBook);
        System.out.println("New book added successfully.");
    }

    private static void addNewMember(Library library, Scanner scanner) {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        Member newMember = new Member(name, memberId);
        library.registerMember(newMember);
        System.out.println("New member added successfully.");
    }

    private static void borrowBook(Library library, Scanner scanner) {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter borrow date (YYYY-MM-DD): ");
        String borrowDate = scanner.nextLine();
        Member member = library.findMemberById(memberId);
        Book book = library.findBookByIsbn(isbn);
        if (member != null && book != null) {
            library.lendBook(book, member, borrowDate);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Invalid member ID or book ISBN.");
        }
    }

    private static void returnBook(Library library, Scanner scanner) {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter return date (YYYY-MM-DD): ");
        String returnDate = scanner.nextLine();
        Member member = library.findMemberById(memberId);
        Book book = library.findBookByIsbn(isbn);
        if (member != null && book != null) {
            library.returnBook(book, member, returnDate);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Invalid member ID or book ISBN.");
        }
    }

    private static void showHistory(Library library) {
        library.displayHistory();
    }

    private static void findMember(Library library, Scanner scanner) {
        System.out.println("Find a member by:");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        Member member = null;
        if (choice == 1) {
            System.out.print("Enter member ID: ");
            String memberId = scanner.nextLine();
            member = library.findMemberById(memberId);
        } else if (choice == 2) {
            System.out.print("Enter member name: ");
            String name = scanner.nextLine();
            member = library.findMemberByName(name);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        if (member != null) {
            System.out.println("Member found: " + member);
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void findBook(Library library, Scanner scanner) {
        System.out.println("Find a book by:");
        System.out.println("1. Title");
        System.out.println("2. ISBN");
        System.out.println("3. Author");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            Book book = library.findBookByTitle(title);
            if (book != null) {
                System.out.println("Book Title: " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
            } else {
                System.out.println("Book not found.");
            }
        } else if (choice == 2) {
            System.out.print("Enter book ISBN: ");
            String isbn = scanner.nextLine();
            Book book = library.findBookByIsbn(isbn);
            if (book != null) {
                System.out.println("Book Title: " + book.getTitle() + " by " + book.getAuthor() );
            } else {
                System.out.println("Book not found.");
            }
        } else if (choice == 3) {
            System.out.print("Enter author name: ");
            String author = scanner.nextLine();
            List<Book> booksByAuthor = library.findBooksByAuthor(author);
            if (!booksByAuthor.isEmpty()) {
                System.out.println("Books by " + author + ":");
                for (Book book : booksByAuthor) {
                    System.out.println("Book Title: " + book.getTitle() + " ISBN: " + book.getIsbn() );
                }
            } else {
                System.out.println("No books found by this author.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
