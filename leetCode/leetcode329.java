/**
 * 题目：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 * 
 * 矩阵中的最长递增路径
 * 
 * 思路
 *      类似分治思想 每个数字的最长递增路径为小于这个数的方向上的长度 + 1
 *      所以可以用一个等大小的二维数组 nm 保存对应位置的最长递增路径
 *      每次向这个方向走的时候先看nm[x][y] 的值是否为0 
 *      不为0这个方向上的最长路径长度就为  nm[x][y] + 1
 *      否则继续递归查找这个位置的最长路径并修改nm[x][y]位置的值
 */
class Solution {
    //保存状态（每个位置的最长路径）
    int[][] nm;
    public int longestIncreasingPath(int[][] matrix) {
        nm = new int[matrix.length][matrix[0].length];
        int ret = 0;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length;j++){    
                ret = Math.max(ret,longes(matrix,i,j));
            }
        }    
        return ret;
    }
    public int longes(int[][] nums,int i,int j){
        int ret = 1;//最短的路径为自己本身（长度为1）

        if(j + 1 < nums[i].length && nums[i][j+1] > nums[i][j]){//看是否可以向右走
            //看右边的状态是否为 0 是继续递归并修改位置的值
            if(nm[i][j+1] == 0){
                nm[i][j+1] = longes(nums,i,j+1);
            }
            ret = Math.max(ret, nm[i][j+1] + 1);
        }
        //同上
        if(i + 1 < nums.length && nums[i+1][j] > nums[i][j]){
            if(nm[i+1][j] == 0){
                nm[i+1][j] = longes(nums,i+1,j);
            }
            ret = Math.max(ret,nm[i+1][j] + 1);
        }
        if(i - 1 >= 0 && nums[i-1][j] > nums[i][j]){
            if(nm[i-1][j] == 0){
                nm[i-1][j] = longes(nums,i-1,j);
            }
            ret = Math.max(ret,nm[i-1][j] + 1);  
        }
        if(j - 1 >= 0 && nums[i][j-1] > nums[i][j]){
            if(nm[i][j-1] == 0){
                nm[i][j-1] = longes(nums,i,j-1);
            }
            ret = Math.max(ret,nm[i][j-1] + 1);
        }
        return ret;
    }
}