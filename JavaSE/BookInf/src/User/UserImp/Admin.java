package User.UserImp;

import Books.BookList;
import User.User;
import Books.Book;
import java.util.Scanner;

/**
 * 管理员类
 */
public class Admin extends User {
    Scanner s = new Scanner(System.in);
    private BookList books;
    public Admin(String name, BookList books) {
        super(name,books);
        this.books = books;
    }
    public void menu(){
        System.out.println("=======华丽的分割线=======");
        System.out.println("1：显示所有图书信息");
        System.out.println("2：删除图书");
        System.out.println("3：借阅图书");
        System.out.println("4：添加图书");
        System.out.println("5：搜索图书");
        System.out.println("6：归还图书");
        System.out.println("0：退出");
    }
    public void remove(){
        System.out.println("请输入要删除的书名：");
        String name  = s.next();
        if(books.search(name)== null){
            System.out.println("找不到要删除的图书信息");
            return;
        }
        books.remove(name);
        System.out.println("删除成功！1");
    }

    public void addBooks(){
        System.out.println("请输入书名：");
        String name = s.next();
        System.out.println("请输入作者：");
        String author = s.next();
        System.out.println("请输入价格：");
        int pr = s.nextInt();
        Book book = new Book(name,author,pr);
        books.add(book);
        System.out.println("添加成功！");
    }
}
