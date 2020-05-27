import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    private Borrower borrower;
    private Book savageDetectives;

    @Before
    public void setUp(){
        borrower = new Borrower("Eugene");
        savageDetectives = new Book("Savage Detectives", "Roberto Bolano", "Literary Fiction");
    }

    @Test
    public void hasName(){
        assertEquals("Eugene", borrower.getName());
    }

    @Test
    public void canCheckBookNumber(){
        assertEquals(0, borrower.bookCount());
    }

    @Test
    public void canAddToCollection(){
        borrower.addToCollection(savageDetectives);
        assertEquals(1, borrower.bookCount());
    }
}
