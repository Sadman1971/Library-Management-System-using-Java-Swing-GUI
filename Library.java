import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private final String FILE_NAME = "library_books.ser";

    public void addBook(Book b) { books.add(b); }
    public List<Book> getBooks() { return books; }

    public boolean borrowBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title) && !b.isBorrowed()) {
                b.borrow();
                return true;
            }
        }
        return false;
    }

    public boolean deleteBook(String title) {
        return books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (List<Book>) in.readObject();
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
    }
}
