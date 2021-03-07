/**
 * 题目：https://leetcode-cn.com/problems/palindrome-partitioning/
 * 
 * 分割回文字符串
 * 
 * 思路
 *      递归加回朔的思想
 *      当idnex走到最后时 将list添加到ret中
 *      当当前的sb.toString()不是回文串不继续递归
 */
import java.util.ArrayList;
import java.util.List;

public class leetcode131 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    static List<List<String>> ret;
    public static List<List<String>> partition(String s) {
        ret = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s,0,list);
        return ret;
    }
    public static boolean isRes(String s){
        int j = s.length()-1;
        int i = 0;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void dfs(String s,int index,List<String> list){

        StringBuilder sb = new StringBuilder();
        if(index == s.length()){
            ret.add(list);
        }
        while(index < s.length()){
            List<String> tmp = new ArrayList<>();
            tmp.addAll(list);
            sb.append(s.charAt(index));
            if(isRes(sb.toString())){
                tmp.add(sb.toString());
                dfs(s,index + 1,tmp);
            }
            index++;
        }
    }
}