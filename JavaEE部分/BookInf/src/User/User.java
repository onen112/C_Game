package User;

/**
 * 用户类；类似service层，调用BooksList的方法实现，顺表保存用户的一些信息
 */

import Books.BookList;
import Books.Book;
import java.util.Scanner;

public class User {
    private BookList books;
    private String name;
    Scanner s = new Scanner(System.in);

    public BookList getBooks() {
        return books;
    }

    public void setBooks(BookList books) {
        this.books = books;
    }

    public Scanner getS() {
        return s;
    }

    public void setS(Scanner s) {
        this.s = s;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public User(String name,BookList books) {
        this.books = books;
        this.name = name;
    }

    public void display(){
        books.display();
    }
    public void search(){
        System.out.println("请输入书名：");
        String name = s.next();
        Book b = books.search(name);
        if(b == null){
            System.out.println("该书不存在！");
        }else{
            System.out.println(b);
        }
    }
    public void borrow(){
        System.out.println("请输入要借的书名：");
        String name = s.next();
        if(books.borrow(name)){
            System.out.println("借阅成功！");
        }else{
            System.out.println("该书不存在或者此书已经借出！");
        }
    }
    public void back(){
        System.out.println("请输入要归还的书名：");
        String  name  = s.next();
        if(books.back(name)){
            System.out.println("归还成功！");
        }else{
            System.out.println("归还失败，不存在这本书，或者，你没借过这本书");
        }
    }
}
