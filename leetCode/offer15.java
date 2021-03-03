/**
 * 题目：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 
 * 二进制中1的个数
 * 
 * lowbit法计算 二进制中1的个数
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int lowbit(int num){
        return num&-num;
    }
    public int hammingWeight(int n) {
        int ret = 0;
        while(n != 0){
            n -= lowbit(n);
            ret++;
        }
        return ret;
    }
}