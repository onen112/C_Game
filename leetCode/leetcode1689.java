/**
 * 题目：https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 * 
 * 十-二进制数的最少数目
 * 
 * 思路：
 *      相等于求其中的最大值即可
 */
class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(int i = 0;i < n.length();i++){
            max = Math.max(max,n.charAt(i)-'0');
        }
        return max;
    }
}