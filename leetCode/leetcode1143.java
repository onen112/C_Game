/**
 * 题目：https://leetcode-cn.com/problems/longest-common-subsequence/
 * 
 * 最长公共序列
 * 
 * 思路：
 *      动态规划 首先填 dp数组的第0行和第0列
 *      然后填写  碰到两个字符相等 判断最大的是不是左上的
 *       是：   dp[i][j] = dp[i-1][j-1]
 *      不是：   dp[i][j] = Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]));
 *      最终返回 dp[x-1][y-1]即可
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int x = text1.length();
        int y = text2.length();
        
        int[][] dp = new int[x][y];
        for(int i = 0;i < dp.length;i++){
            if(text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;  
            }else{
                if(i != 0){
                    dp[i][0] = dp[i-1][0];
                }
            }
        }
        for(int i = 0;i < dp[0].length;i++){
            if(text1.charAt(0) == text2.charAt(i)){
                dp[0][i] = 1;    
            }else{
                if(i != 0){
                    dp[0][i] = dp[0][i-1];
                }
            }
        }

        for(int i = 1;i < x;i++){
            for(int j = 1;j < y;j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    int n = Math.max(dp[i-1][j],dp[i][j-1]);
                    if(n > dp[i-1][j-1]){
                        dp[i][j] = n;
                    }else{
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                    
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]));
                }
            }
        }

        return dp[x-1][y-1];
    }
}