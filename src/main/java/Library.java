import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private String name;
    private ArrayList<Book> collection;
    private int capacity;
    private HashMap<String, Integer> bookRegistry;

    public Library(String name, int capacity) {
        this.name = name;
        this.collection = new ArrayList<Book>();
        this.capacity = capacity;
        this.bookRegistry = new HashMap<String, Integer>();
    }

    public String getName() {
        return this.name;
    }

    public int bookCount() {
        return this.collection.size();
    }

    public void addBook(Book book) {
        this.collection.add(book);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean checkCapacity() {
        if (getCapacity() >= bookCount()) {
            return true;
        } else {
            return false;
        }
    }

    public void addBookToStock(Book book) {
        if (checkCapacity()){
            this.collection.add(book);
        }
    }

    public void checkOutBook(Borrower borrower, Book book) {
        if (hasBook(book)) {
            borrower.addToCollection(book);
            this.removeBook(book);
        }

    }

    public boolean hasBook(Book book) {
        if (this.collection.contains(book)) {
            return true;
        } else {
            return false;
        }
    }

    public void removeBook(Book book) {
        if (hasBook(book)) {
            this.collection.remove(book);
        }
    }

//    public void addToRegistry(Book book) {
//        int count = this.bookRegistry.containsKey(book.getGenre()) ? bookRegistry.get(book.getGenre()) : 0;
//        this.bookRegistry.put(book.getGenre(), count + 1);
//    }
}
