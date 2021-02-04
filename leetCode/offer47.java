/**
 * 题目：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 
 * 礼物的最大值
 * 
 * 思路：
 *      经典的动态规划问题
 *      grid[i][j] = max(grid[i-1][j],grid[i][j-1])+grid[i][j]  
 *      即可解出答案
 */
class Solution {
    public int maxValue(int[][] grid) {
        int x = grid.length;
        if(x == 0) return 0;
        int y = grid[0].length;
        for(int i = 0;i < x;i++){
            for(int j = 0;j < y;j++){
                if(i == 0&&j!=0){
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                }else if(j == 0&& i!= 0){
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                }else if(i != 0&& j != 0){
                    grid[i][j] = grid[i][j] + Math.max(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[x-1][y-1];
    }
}