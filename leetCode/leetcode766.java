/**
 * 题目：https://leetcode-cn.com/problems/toeplitz-matrix/
 * 
 * 托普利茨矩阵
 * 
 * 思路
 *      使用一个队列存储上一行元素的值，然后用当前行的元素从第二个开始去比较
 *      如果有不相等的地方返回false 否则更新队列的值 继续执行 返回 true
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length == 0) return true;
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0;i < matrix[0].length;i++){
            qu.offer(matrix[0][i]);
        }
        for(int i = 1;i < matrix.length;i++){
            qu.offer(matrix[i][0]);
            for(int j = 1;j < matrix[i].length;j++){
                if(qu.poll() != matrix[i][j]){
                    return false;
                }
                qu.offer(matrix[i][j]);
            }
            qu.poll();
        }
        return true;
    }
}