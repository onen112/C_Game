/**
 * 题目：https://leetcode-cn.com/problems/max-consecutive-ones/
 * 
 * 最大连续1的个数
 * 
 * 思路
 *      快慢指针实现 每次遇到0就去判断是否要更新ret的值
 *      如果nums[end] == 0  就让end一直往后走 走到nums[end] != 0
 *      顺便更新start的值
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int end = 0;
        int ret = 0;
        while(end < nums.length){
            if(nums[end] == 0){
                ret = Math.max(ret,end - start);
                while(end < nums.length&&nums[end] == 0){
                    end++;
                }
                start = end;
            }else{
                end++;
            }
        }
        ret = Math.max(ret,end - start);
        return ret;
    }
}