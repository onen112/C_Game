/**
 * 题目：https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * 
 * 阶乘后的零
 * 
 * 思路
 *      看这个数中能成对出现的2和5的个数
 */
class Solution {
    public int trailingZeroes(int n) { 
        int ret = 0;
        while(n != 0){
            ret += n/5;
            n/=5;
        }
        return ret;
    }
}