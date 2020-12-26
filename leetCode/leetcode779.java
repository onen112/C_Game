/**
 * 题目：
 *      https://leetcode-cn.com/problems/k-th-symbol-in-grammar/
 * 思路1
 *      暴力递归（失败 如下注释部分）
 *      每次下一行的数字长度都是上一行的二倍，所以当N = 30时 数字是相当大的
 * 思路2
 *      找规律 + 递归
 *      通过观察
 *          第N行第K个的值与N-1行的（K+1）/2 位有关系
 *          当N-1行的（K+1)/2 = 0 返回值应是： 1-k%2
 *          否则返回
 *              k%2
 *
 */

public class leetcode779 {
    public static void main(String[] args) {
        System.out.println(kthGrammar(4,5));
    }

    public static int kthGrammar(int N, int K) {
        if(K == 0){
            return 0;
        }
        if(N == 0){
            return 0;
        }
        if(kthGrammar(N-1,(K+1)/2) == 0){
            return 1 - (K%2);
        }else{
            return K%2;
        }
    }
//失败方法，不可取啊
//  public static int kthGrammar(int N, int K) {
//      return dfs(N,K,"0",1)-'0';
//  }
//    public static char dfs(int N,int K,String str,int n){
//        if(n == N){
//            return str.charAt(K-1);
//        }
//        String s = "";
//        for(int i = 0;i < str.length();i++){
//            if(str.charAt(i) == '0'){
//                s += "01";
//            }else{
//                s += "10";
//            }
//        }
//        return dfs(N,K,s,n+1);
//    }
}