/**
 * 题目：https://leetcode-cn.com/problems/monotonic-array/
 * 
 * 单调数列
 * 
 * 先遍历判断是增还是减
 * 然后继续走完如果和开始的不一致返回false
 */
class Solution {
    public boolean isMonotonic(int[] A) {
        if(A.length <= 2) return true;
        boolean inc = true;
        int i = 1; 
        for(;i < A.length;i++){
            if(A[i] < A[i-1]){
                inc = true;
                break;
            }else if(A[i] > A[i-1]){
                inc = false;
                break;
            }
        }
        i++;
        for(;i < A.length;i++){
            if(A[i] == A[i-1]){

            }
            else if(A[i] < A[i-1] != inc){
                return false;
            }
        }
        return true;
    }
}