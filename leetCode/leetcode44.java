/**
 * 题目：https://leetcode-cn.com/problems/wildcard-matching/
 * 
 * 通配符匹配
 * 
 * 思路：
 *      采用动态规划的思想状态转移方程分情况推进
 *      定义一个二维的boolean型数组 长度为s.length()+1,p.length()+1
 *      遍历字符串 s 和 p 当s.charAt(i) == p.charAt(j)||p.charAt(j)=='?'
 *      dp[i][j] = dp[i-1][j-1]
 *      当p.charAt(j) == '*' -》 dp[i][j] = dp[i][j-1]|| dp[i-1][j];
 *      最终 返回dp[s.length()][p.length()]
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) return true;
        int x = s.length()+1;
        int y = p.length()+1;
        boolean[][] dp = new boolean[x][y];
        
        dp[0][0] = true;
        for(int i = 1;i < y;i++){
            dp[0][i] = dp[0][i-1] && p.charAt(i-1) == '*';
        }
        for(int i = 1;i < x;i++){
            dp[i][0] = false;
        }

        for(int i = 1;i < x;i++){
            for(int j = 1;j < y;j++){
                if(p.charAt(j-1) == s.charAt(i-1) ||p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){                                 
                    dp[i][j] = dp[i][j-1] == true || dp[i-1][j] == true;  
                }
            }
        }

        return dp[x-1][y-1];

    }
}