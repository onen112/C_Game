/**
 * 题目：https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * 子数组的最大平均数
 * 
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 
 * 思路：
 *      先求出前k个元素的和sum 然后继续向后走，每次维护sum的值
 *      如果 sum > ret 修改ret的值
 *      最后返回 ret*1.0/k 即可 
 * 
 * 细节：
 *      赋值时进行类型转换会比较慢，不如直接在返回时*1.0来的快
 * 
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int ret = 0;
        int num = 0;
        int i = 0;
        int j = 0;
        for(;i < k;i++){
            num += nums[i]; 
        }
        ret = num; 
        while(i < nums.length){
            num -= nums[j++];
            num += nums[i++];
            ret = Math.max(ret,num);
        }
        return ret*1.0/k;
    }
}