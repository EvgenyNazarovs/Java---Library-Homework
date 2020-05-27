import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void setUp(){
        book = new Book("Extinction", "Thomas Bernhard", "Literary Fiction");

    }

    @Test
    public void hasTitle(){
        assertEquals("Extinction", book.getTitle());
    }

    @Test
    public void hasAuthor(){
        assertEquals("Thomas Bernhard", book.getAuthor());
    }

    @Test
    public void hasGenre(){
        assertEquals("Literary Fiction", book.getGenre());
    }

}
