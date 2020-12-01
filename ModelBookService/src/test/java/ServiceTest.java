import ModelBook.Book;
import Service.BookService;
import org.junit.Test;
import validator.AuthorDateValidator;

public class ServiceTest {
    @Test
    public void serviceTest()
    {
        BookService list = new BookService();
        System.out.println(list.getAllWhereBookYearIsBetween(1900, 1940));
        System.out.println(list.getAllByBookName("name"));
        System.out.println(list.getAllByBookAuthor("author"));
        System.out.println(list.getAllByBookGenre("roman"));
        System.out.println(list.getBooks());

        AuthorDateValidator validator = new AuthorDateValidator();
        validator.isValid(Book.getYear)

    }
}
