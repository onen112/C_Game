package User.UserImp;

import Books.BookList;
import User.User;

/**
 * 普通用户类
 */
public class Ordinary extends User {
    public Ordinary(String name, BookList books) {
        super(name,books);
    }
    public void menu(){
        System.out.println("=======华丽的分割线=======");
        System.out.println("1：显示所有图书信息");
        System.out.println("2：借阅图书");
        System.out.println("3：搜索图书");
        System.out.println("4：归还图书");
        System.out.println("0：退出");
    }
}
