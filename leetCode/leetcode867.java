/**
 * 题目：https://leetcode-cn.com/problems/transpose-matrix/
 * 
 * 矩阵转置
 * 
 * 思路
 *      将数组的i j下标元素赋值给新数组 j i 下标元素即可
 * 
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        if(matrix.length == 0) return matrix;
        int[][] ret = new int[matrix[0].length][matrix.length];
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                ret[j][i] = matrix[i][j];
            }
        }
        return ret;
    }
}