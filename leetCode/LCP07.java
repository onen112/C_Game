/**
 * 题目：https://leetcode-cn.com/problems/chuan-di-xin-xi/
 * 
 * 传递信息
 * 
 * 动态规划 从上一轮能送达的推到下一轮能送达的人
 */
class Solution {
    public int numWays(int n, int[][] relation, int k) {
       int[][] dp = new int[k+1][n];
        dp[0][0] = 1;// 表示第0轮传递到编号为0的小朋友的总方案数
       for(int i = 1;i <= k;i++){
           for(int[] r : relation){
               dp[i][r[1]] += dp[i-1][r[0]];
           }
       } 
       return dp[k][n-1];
    }
}