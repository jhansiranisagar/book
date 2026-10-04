import java.util.*;

public class Library {

    private Map<String, Book> catalog;
    private Map<Integer, Borrower> members;
    private Map<String, Integer> checkedOut;

    public Library() {
        catalog = new HashMap<>();
        members = new HashMap<>();
        checkedOut = new HashMap<>();
    }

    public void addBook(Book book) {
        catalog.put(book.getIsbn(), book);
        checkedOut.put(book.getIsbn(), null);
    }

    public void registerBorrower(Borrower borrower) {
        members.put(borrower.getId(), borrower);
    }

    public boolean checkoutBook(String isbn, int borrowerId) {
        if (!catalog.containsKey(isbn)) {
            return false;
        }

        if (!members.containsKey(borrowerId)) {
            return false;
        }

        if (checkedOut.get(isbn) != null) {
            return false;
        }

        checkedOut.put(isbn, borrowerId);
        return true;
    }

    public boolean returnBook(String isbn) {
        if (!catalog.containsKey(isbn)) {
            return false;
        }

        if (checkedOut.get(isbn) == null) {
            return false;
        }

        checkedOut.put(isbn, null);
        return true;
    }

    public List<Book> listAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();

        for (String isbn : catalog.keySet()) {
            if (checkedOut.get(isbn) == null) {
                availableBooks.add(catalog.get(isbn));
            }
        }

        return availableBooks;
    }

    public List<Book> listBorrowedBooks(int borrowerId) {
        List<Book> borrowedBooks = new ArrayList<>();

        for (String isbn : checkedOut.keySet()) {
            Integer id = checkedOut.get(isbn);

            if (id != null && id == borrowerId) {
                borrowedBooks.add(catalog.get(isbn));
            }
        }

        return borrowedBooks;
    }
}
