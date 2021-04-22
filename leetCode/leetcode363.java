/**
 * 题目：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * 
 * 矩形区域不超过 K 的最大数值和
 * 
 * 思路：二维前缀和 + 二维滑动窗口
 *      基本等于爆破 四层for循环 不过勉强跑过
 */

class Solution {
    int res = Integer.MIN_VALUE;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] add = new int[matrix.length+1][matrix[0].length+1];

        //初始化前缀和数组
        for(int i = 1;i < add.length;i++){
            for(int j = 1;j < add[i].length;j++){
                add[i][j] = matrix[i-1][j-1] + add[i-1][j] + add[i][j-1] - add[i-1][j-1];
                
            }

        }
        //尝试没种长宽的滑动窗口
        for(int i = 0;i < add.length-1;i++){
            for(int j = 0;j < add[i].length-1;j++){
                isMax(add,i,j,k);
            }
        }
        return res;
    }
    public void isMax(int[][] matrix,int m,int n,int k){
        int s=0;

        //开始滑
        for(int i=1;i+m<matrix.length;i++){
            for(int j=1;j+n<matrix[0].length;j++){
                s=matrix[i+m][j+n]-matrix[i-1][j+n]-matrix[i+m][j-1]+matrix[i-1][j-1];
                //小于等于k 看是否更新
                if(s<=k){
                    res = Math.max(res,s);
                }     
            }

        }
    }
}