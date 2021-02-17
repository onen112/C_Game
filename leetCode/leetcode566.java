/**
 * 题目：https://leetcode-cn.com/problems/reshape-the-matrix/
 * 
 * 重塑矩阵
 * 
 * 思路
 *      通过两个变量表示矩阵的行和列 然后依次进行赋值
 */
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length == 0 ||nums.length * nums[0].length != r * c){
            return nums;
        }
        int[][] ret = new int[r][c];
        int x = 0,y = 0;
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < nums[0].length;j++){
                if(y < c){
                    ret[x][y] = nums[i][j];
                    y++;
                }
                if(y == c){
                    y = 0;
                    x++;
                }
            }
        }
        return ret;
    }
}