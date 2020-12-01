import ModelBook.Book;
import Service.BookService;

public class Main {
    public Main()
    {

    }
    public static void main(String[] args)
    {
        Book book = new Book("name", "author",1928, "genre");
        BookService service = new BookService();
        int year = 1928;
        System.out.println(service.compareYears(book, year));
    }
}
