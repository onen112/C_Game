/**
 * 题目：https://leetcode-cn.com/problems/flipping-an-image/
 * 
 * 翻转图像
 * 
 * 思路
 *      先把所有的 0 1 与 1 进行异或
 *      每次执行一行整行的反转
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A.length == 0) return A;
        for(int i = 0;i < A.length;i++){
            for(int j = 0;j < A[0].length;j++){
                A[i][j] ^= 1; 
            }
            A[i] = reversal(A[i]);
        }
        return A;
    }
    public int[] reversal(int[] arr){
        int[] ret = new int[arr.length];
        for(int i = 0;i < ret.length;i++){
            ret[i] = arr[arr.length - 1-i];
        }
        return ret;
    }
}
