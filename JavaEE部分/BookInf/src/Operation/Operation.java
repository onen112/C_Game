package Operation;

import Books.Book;

/**
 * 要用到的方法的接口
 */
public interface Operation {
    //添加图书
    void add(Book book);
    //搜索图书
    Book search(String name);
    //删除图书
    void remove(String name);
    //打印所有图书
    void display();
    //借书
    boolean borrow(String name);
    //还书
    boolean back(String name);
}
