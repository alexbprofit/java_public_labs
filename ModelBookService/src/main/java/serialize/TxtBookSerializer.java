package serialize;


import ModelBook.Book;

import java.io.*;

public class TxtBookSerializer implements Serializer<Book> {
    private Class<Book> clazz;

    public TxtBookSerializer(Class<Book> type) {
        this.clazz = type;
    }

    public Class<Book> getClazz() {
        return clazz;
    }

    public void setClazz(Class<Book> clazz) {
        this.clazz = Book.class;
    }

    @Override
    public void toFile(Book obj, File file) throws IOException {
        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (FileNotFoundException e) {
            //TODO
        }
    }

    @Override
    public Book fromFile(File file) throws IOException, ClassNotFoundException{
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            istream = new ObjectInputStream(fis);
            // десериализация
            return (Book) istream.readObject();

        } catch (FileNotFoundException e) {
            //TODO
        }
        return null;
    }

    @Override
    public String toString(Book obj) {
        return null;
    }

    @Override
    public Book fromString(String string) {
        return null;
    }
}


