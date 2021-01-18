import Books.BookList;
import User.User;
import User.UserImp.Admin;
import User.UserImp.Ordinary;
/**
 * javaEE 部分的第一个实例  图书管理系统
 *      没有用图形化界面，没有前后端，没有数据库
 *      只是测试类与对象和继承，接口等
 *      
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int choose;
        User user = null;
        BookList books = new BookList();
        System.out.println("需要确认宁的身份：1：管理员====2：普通用户");
        do {
            choose = s.nextInt();
            if(choose == 1){
                user = new Admin("",books);
            }else if(choose == 2) {
                user = new Ordinary("",books);
            }
            if(!(choose == 1||choose == 2)){
                System.out.println("输入内容有误，请重试！");
            }
        }while(choose != 1&&choose != 2);
        System.out.println("请输入宁的姓名：");
        String name = s.next();
        user.setName(name);

        System.out.println("宁好" + user.getName() + "欢迎访问");
        if(choose == 1){
            user = (Admin)user;
            while(true){
                ((Admin) user).menu();
                int ch = s.nextInt();
                switch (ch){
                    case 0:System.exit(1);break;
                    case 1:((Admin) user).display();break;
                    case 2:((Admin) user).remove();break;
                    case 3:((Admin) user).borrow();break;
                    case 4:((Admin) user).addBooks();break;
                    case 5:((Admin) user).search();break;
                    case 6:user.back();break;
                    default:
                        System.out.println("输入有误，请重试！");
                }
            }
        }else{
            user = (Ordinary)user;
            while(true){
                ((Ordinary) user).menu();
                int ch = s.nextInt();
                switch (ch){
                    case 0:System.exit(1);break;
                    case 1:user.display();break;
                    case 2:user.borrow();break;
                    case 3:user.search();break;
                    case 4:user.back();break;
                    default:
                        System.out.println("输入有误，请重试！");
                }
            }

        }
    }
}
