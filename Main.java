import java.util.List;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book("ISBN001", "Java Programming", "James Gosling"));
        library.addBook(new Book("ISBN002", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("ISBN003", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("ISBN004", "Head First Java", "Kathy Sierra"));
        library.addBook(new Book("ISBN005", "Data Structures", "Mark Allen"));

        library.registerBorrower(new Borrower(101, "Reshma"));
        library.registerBorrower(new Borrower(102, "Anjali"));
        library.registerBorrower(new Borrower(103, "Priya"));

        System.out.println("Checkout ISBN001 by Reshma: "
                + library.checkoutBook("ISBN001", 101));

        System.out.println("Checkout ISBN002 by Anjali: "
                + library.checkoutBook("ISBN002", 102));

        System.out.println("Checkout ISBN003 by Reshma: "
                + library.checkoutBook("ISBN003", 101));

        System.out.println("Checkout ISBN001 by Priya: "
                + library.checkoutBook("ISBN001", 103));

        System.out.println("\nAvailable Books:");

        List<Book> availableBooks = library.listAvailableBooks();

        for (Book book : availableBooks) {
            System.out.println(book);
        }

        System.out.println("\nBooks borrowed by Reshma:");

        List<Book> borrowedBooks = library.listBorrowedBooks(101);

        for (Book book : borrowedBooks) {
            System.out.println(book);
        }

        System.out.println("\nReturning ISBN001: "
                + library.returnBook("ISBN001"));

        System.out.println("\nAvailable Books after returning ISBN001:");

        for (Book book : library.listAvailableBooks()) {
            System.out.println(book);
        }
    }
}
