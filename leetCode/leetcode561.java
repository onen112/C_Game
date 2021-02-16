/**
 * 题目：https://leetcode-cn.com/problems/array-partition-i/
 * 
 * 数组拆分 I
 * 
 * 思路
 *      先对数组进行排序，然后每次走两个
 *      累加求和并返回即可
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i = 0;i < nums.length;i += 2){
            ret += nums[i];
        }
        return ret;
    }
}