import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LibraryTest {

    private Library library;
    private Book savageDetectives;
    private Borrower borrower;
    private Book javaScriptBook;

    @Before
    public void setUp(){
        library = new Library("Hillhead Library", 100);
        savageDetectives = new Book("Savage Detectives", "Roberto Bolano", "Literary Fiction");
        javaScriptBook = new Book("JavaScript", "James", "Textbook");
        borrower = new Borrower("Eugene");
    }

    @Test
    public void hasName(){
        assertEquals("Hillhead Library", library.getName());
    }

    @Test
    public void canCountBooks(){
        assertEquals(0, library.bookCount());
    }

    @Test
    public void canAddABook(){
        library.addBook(savageDetectives);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void hasCapacity(){
        assertEquals(100, library.getCapacity());
    }

    @Test
    public void canCheckCapacity(){
        assertEquals(true, library.checkCapacity());
    }

    @Test
    public void canAddBookToStock(){
        library.addBookToStock(savageDetectives);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void hasSpecificBook(){
        library.addBookToStock(savageDetectives);
        assertEquals(true, library.hasBook(savageDetectives));
    }

    @Test
    public void canRemoveBook(){
        library.addBookToStock(savageDetectives);
        library.removeBook(savageDetectives);
        assertEquals(0, library.bookCount());
    }

    @Test
    public void canCheckOutBookToBorrower(){
        library.addBookToStock(savageDetectives);
        library.checkOutBook(borrower, savageDetectives);
        assertEquals(0, library.bookCount());
        assertEquals(1, borrower.bookCount());
    }

    @Test
    public void canAddToRegistry() {
        library.addToRegistry(savageDetectives);
        library.addToRegistry(savageDetectives);
        int numberOfBooks = library.getBooksPerGenre("Literary Fiction");
        assertEquals(2, numberOfBooks);
    }

    @Test
    public void canAddToRegistryAndStock() {
        library.addBookToStock(savageDetectives);
        library.addBookToStock(savageDetectives);
        library.addBookToStock(javaScriptBook);
        int numberOne = library.getBooksPerGenre("Literary Fiction");
        int numberTwo = library.getBooksPerGenre("Textbook");
        assertEquals(2, numberOne);
        assertEquals(1, numberTwo);

    }

}
