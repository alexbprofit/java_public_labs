package Service;

import ModelBook.Book;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class BookService implements Comparable<Book>, Comparator<Book> {
    private List<Book> books = new ArrayList<>();
    {
        books.add(buildNewValidBooks("name", "author",1934,"roman"));
        books.add(buildNewValidBooks("namdsae", "autho2r",1944,"roman"));
        books.add(buildNewValidBooks("namde", "autdashor",1936,"roman"));
        books.add(buildNewValidBooks("namae", "authfor",1914,"romadn"));
    }

    public List<Book> getAllByBookName(String name) {
        return getBooks().stream().filter(item->item.getName()
                .equals(name))
                .collect(Collectors.toList());
    }
    public List<Book> getAllByBookAuthor(String author) {
        return getBooks().stream().filter(item->item.getAuthor()
                .equals(author))
                .collect(Collectors.toList());
    }
    public List<Book> getAllByBookGenre(String genre) {
        return getBooks().stream().filter(item->item.getGenre()
                .equals(genre))
                .collect(Collectors.toList());
    }

    public List<Book> getAllWhereBookYearIsBetween(int first, int second) {
        return getBooks().stream().
                filter(item->item.getDate() >= first && item.getDate() <= second)
                .collect(Collectors.toList());
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public int compare(Book o1, Book o2) {
        if (o1.year == o2.year) {
            return 0;
        }
        else {
            return -1;
        }
    }

    public BookService() {
        super();
    }

    public int compareYears(@NotNull Book o, int year){
        return Integer.compare(year, o.year);
    }
    public boolean addBook (Book book, String name) {
        return false;
    }

    public int addByBookName(String name) {
        List<Map<Book, String>> counts = new ArrayList<>();
        return 0;
    }

    @Override
    public int compareTo(@NotNull Book o) {
        return 0;
    }
    private Book buildNewValidBooks(String name, String author, Integer year, String genre) {
        return new Book(name, author, year, genre);
    }
}
