/**
 * 题目：https://leetcode-cn.com/problems/distinct-subsequences/
 * 
 * 不同的子序列
 * 
 * 思路：
 *      动态规划 用 i j 表示在 t 和 s上的位置
 *      
 *      dp[i][j] = dp[i-1][j-1] + dp[i][j-1]  <- s.charAt(j) == t.charAt(i)
 *      dp[i][j] = dp[i][j-1]    <-  s.charAt(j) != t.charAt(i)
 */
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n < m) return 0;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i < n+1;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i < m+1;i++){
            for(int j = 1;j < n+1;j++){
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            } 
        }
        return dp[m][n];
    }
}
