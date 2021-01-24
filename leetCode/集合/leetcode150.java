/**
 * 题目：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 *  逆波兰表达式求值
 *      思路：
 *          使用栈先进先出的特性
 *          每次如果读到的值是数字就进行入栈
 *          如果是运算符就拿出栈中的两个值，用这个运算符进行运算
 *          直到取完为止（第一个值需要作为运算的右值）
 * 
 */
import java.util.Stack;
public class leetcode150 {
    public static void main(String[] args) {
        evalRPN(new String[]{"2","1","+","3","*"});
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < tokens.length;i++){
            if(!tokens[i].equals("+")&&!tokens[i].equals("-")&&!tokens[i].equals("*")&&!tokens[i].equals("/")){
                stack.add(Integer.parseInt(tokens[i]));
            }else{
                int r = stack.pop();
                int l = stack.pop();
                stack.add(fun(l,r,tokens[i]));
            }
        }
        System.out.println(stack.pop());
        return stack.pop();
    }
    public static int fun(int l,int r,String symbol){
        if(symbol.equals("+")){
            return l+r;
        }
        if(symbol.equals("-")){
            return l-r;
        }
        if(symbol.equals("*")){
            return l*r;
        }
        if(symbol.equals("/")){
            return l/r;
        }
        return -1;
    }
}
