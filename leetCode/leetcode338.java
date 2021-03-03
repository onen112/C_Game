/**
 * 题目：https://leetcode-cn.com/problems/counting-bits/
 * 
 * 比特位计数
 * 
 * 思路：
 *      0中有1个1
 *      之后每个数 n 中1的个数为：
 *      n>>1中1的个数加上 n&1的结果（杨老师yyds）
 * 
 * 除此之外 计算一个数中1的个数可以用lowbit的方法
 * 详见：https://github.com/onen112/LearnAndTest/blob/master/leetCode/offer15.java
 */
class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for(int i = 1;i <=num;i++){
            ret[i] = ret[i>>1] + (i & 1);
        }
        return ret;
    }
}