/**
 * 题目：https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * 
 * 二维区域和检索 - 矩阵不可变
 * 
 * 思路
 *      一个二维数组中的前缀和 重新定义一个数组保存当前下标到 0 0
 *      范围内的和 最后返回值也按照要求返回即可
 */
class NumMatrix {
    int[][] matrix;
    int[][] tmp;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if(matrix.length != 0){
            tmp = new int[matrix.length+1][matrix[0].length+1];
            for(int i = 0;i < matrix.length;i++){
                for(int j = 0;j < matrix[0].length;j++){
                    tmp[i+1][j+1] += matrix[i][j];
                    tmp[i+1][j+1] -= tmp[i][j];
                    tmp[i+1][j+1] += tmp[i+1][j];
                    tmp[i+1][j+1] += tmp[i][j+1];
                }
            }
        }else{
            tmp = new int[1][1];
        }
        
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.tmp[row2+1][col2+1] - this.tmp[row1][col2+1] - this.tmp[row2+1][col1] + this.tmp[row1][col1];
    }
}