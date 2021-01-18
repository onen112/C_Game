package Books;

/**
 * 图书对象
 */
public class Book {
    private String name;
    private String author;
    private int  price;
    private boolean isBorrowed;

    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.isBorrowed = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        String borrow = this.isBorrowed?"可借":"不可借";
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", isBorrowed=" + borrow +
                '}';
    }
}
