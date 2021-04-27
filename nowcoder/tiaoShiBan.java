/**
 * 题目：https://www.nowcoder.com/questionTerminal/4284c8f466814870bae7799a07d49ec8
 * 
 * 跳石板
 * 
 * 思路：
 *      动态规划 + 优化（dfs会超时）
 *      定义一个一维的dp数组然后 能到达的块可以到下一个
 *      每次如果遍历的这个是可以到达的 则更新他的下面的块
 * 
 */

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        if(n == m){
            System.out.println(0);
            return;
        }
        //初始化dp数组
        int[] dp = new int[m-n+1];
        for(int i = 2;i < dp.length && i <= Math.sqrt(n);i++){
            if(n%i == 0){
                dp[i] = 1;
                dp[n/i] = 1;
            }
        }
        
        //开始动态规划
        for(int i = n+1;i <= m;i++){
            //可以到这个点 就可以继续向后走 否则下一个
            if(dp[i-n] != 0){
                for(int j = 2;j <= Math.sqrt(i);j++){
                    //他的下一个还在dp的长度内 而且 可以到达
                    if(i+j-n < dp.length  && i%j == 0){
                        if(dp[i+j-n] == 0){
                            dp[i+j-n] = dp[i-n]+1;
                        }else{
                            dp[i+j-n] = Math.min(dp[i+j-n],dp[i-n]+1);
                        }
                        //每次初始化两个
                        if(i-n+(i/j) < dp.length){
                            if(dp[i-n+(i/j)] == 0){
                                dp[i-n+(i/j)] = dp[i-n]+1;
                            }else{
                                dp[i-n+(i/j)] = Math.min(dp[i-n+(i/j)],dp[i-n]+1);
                            }
                        }
                    }
                    
                }
            }
        }
        //输出结果
        if(dp[m-n] == 0){
            System.out.println(-1);
        }else{
            System.out.println(dp[m-n]);
        }
    }
}