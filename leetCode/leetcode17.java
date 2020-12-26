
import java.util.ArrayList;
import java.util.List;

/**
 *  题目：
 *       https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *  思路：
 *       通过递归实现深度优先遍历，把每一种情况进行组合，然后返回
 */
public class leetcode17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("64426"));
    }
    //用于查找每个按键，则每个按键对应位置： digits.charAt(n)-'0'-2; 
    public static char[][] c = new char[][]{
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };
    //用于作为返回值进行返回
    public static List<String> ret = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
       //开始执行传入：按键的字符串  初始字符串（空的） 和开始的位置（从0开始）
       dfs(digits,"",0);
       return ret;
    }
    public static void dfs(String digits,String str,int n){
        //递归结束条件当走到最后一个按键的位置（n == digits.length()） 结束并添加到返回数组中
        if(n == digits.length()){
            ret.add(str);
            return;
        }
        //如果没结束 获取当前按键的在c数组种对应的位置
        int j = digits.charAt(n)-'0'-2;
        //将当前数字所对应的每个字符都拼接并进行下一步递归操作
        for(int i = 0;i < c[j].length;i++){
            dfs(digits,str+c[j][i],n+1);
        }
    }
}