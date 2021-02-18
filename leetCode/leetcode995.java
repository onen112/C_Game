/**
 * 题目：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/
 * 
 * K 连续位的最小翻转次数
 * 
 * 思路：
 *      贪心算法 每次遇到0就讲后面的k个反转
 *      然后记录需要的次数
 */
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (i + k > n) return -1;
                for (int j = i; j < i + k; j++) nums[j] ^= 1;
                ret++;
            }
        }
        return ret;
    }
}