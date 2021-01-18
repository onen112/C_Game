package Books;

import Operation.Operation;

/**
 * 图书列表，用于保存图书信息，并实现对应的方法
 */
public class BookList implements Operation{
    private int size = 0;
    private Book[] books;

    public BookList(){
        this.books = new Book[20];
        books[0] = new Book("西游记","罗贯中",21);
        books[1] = new Book("红楼梦","曹雪芹",25);
        books[2] = new Book("水浒传","施耐庵",30);
        this.size = 3;
    }

    @Override
    public void add(Book book) {
        this.books[size] = book;
        this.size++;
    }

    @Override
    public Book search(String name) {
        for(int i = 0;i < this.size;i++){
            if(name.equals(this.books[i].getName())){
                return this.books[i];
            }
        }
        return null;
    }

    @Override
    public void remove(String name) {
        int i;
        for(i = 0;i < this.size;i++){
            if(name.equals(books[i].getName())){
                break;
            }
        }
        if(i < this.size){
            for(;i < this.size;i++){
                books[i] = books[i+1];
            }
            this.size--;
        }
    }

    @Override
    public void display() {
        for(int i = 0;i < size;i++){
            System.out.println(books[i]);
        }
    }

    @Override
    public boolean borrow(String name) {
        int i = 0;
        for(;i < size;i++){
            if(books[i].getName().equals(name)){
                break;
            }
        }
        if(i >= size||!books[i].isBorrowed()){
            return false;
        }
        books[i].setBorrowed(false);
        return true;
    }

    @Override
    public boolean back(String name) {
        if(this.search(name) != null && !this.search(name).isBorrowed()){
            this.search(name).setBorrowed(true);
            return true;
        }else{
            return false;
        }
    }



}
