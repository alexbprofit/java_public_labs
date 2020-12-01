package ModelBook;

import java.lang.annotation.Annotation;
import java.util.Objects;

public class BookManager implements Annotation {
    public int managerId;
    public String managerName;
    public int countOfBooks;

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getManagerId() {
        return this.managerId;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerName() {
        return this.managerName;
    }
    public void setCountOfBooks(int countOfBooks) {
        this.countOfBooks = countOfBooks;
    }

    public int getCountOfBooks() {
        return this.countOfBooks;
    }
    @Override
    public String toString() {
        String buf_str = "";
        buf_str = buf_str + managerName +"\t" + countOfBooks +"\n";
        return buf_str;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass()!=o.getClass()) return false;
        BookManager that = (BookManager) o;
        return managerName.equals(that.managerName) && countOfBooks == that.countOfBooks;

    }
    @Override
    public int hashCode() {
        return Objects.hash(managerName, countOfBooks);
    }

}
