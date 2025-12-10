import java.util.ArrayList;

public class Library {
    Book book;
    ArrayList<Book> books;
    public Library(Book book) {
        this.book = book;
        this.books = new ArrayList<>();
    }
    public void addBook(Book book) {
        this.books.add(book);
    }
    public void removeBook(String ISBN) {
        if (ISBN == null) {
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            if  (books.get(i).getISBN().equals(ISBN)) {
                books.remove(i);
                break;
            }
        }
    }
    public Book[] searchBook(String bookTitle) {
        if (bookTitle == null) {
            return null;
        }
        ArrayList<Book> matchedBooks = new ArrayList<>();
        for  (int i = 0; i < books.size(); i++) {
            if  (books.get(i).getTitle().contains(bookTitle)) {
                matchedBooks.add(books.get(i));
            }
        }
        return matchedBooks.toArray(new Book[0]);
    }
}
