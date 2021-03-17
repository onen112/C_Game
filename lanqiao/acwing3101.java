/**
 * 题目：https://www.acwing.com/problem/content/3174/
 * 
 * 耐摔指数
 * 
 * 思路：
 *      动态规划  i 表示手机数目 j 表示当前楼层高度
 *      状态转移方程：
 *          dp[i][j] = j; i==1
 *          dp[i][j] = min(max(dp[i][j-k]+1,dp[i-1][k-1]+1),dp[i][j])  i!=1
 *      其中k取 1-j
 *      
 *      最后返回dp[3][n] 即可          
 */
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int[][] dp = new int[4][n+1];
        
        for(int i = 1;i < dp[1].length;i++){
            dp[1][i] = i;
        }
        
        for(int i = 2;i <= 3;i++){
            for(int j = 1;j < dp[i].length;j++){
                dp[i][j] = j;
                for(int k = 1;k <= j;k++){
                    dp[i][j] = Math.min(Math.max(dp[i][j-k]+1,dp[i-1][k-1]+1),dp[i][j]);  
                }
            }
        }
        System.out.println(dp[3][n]);
    }
}