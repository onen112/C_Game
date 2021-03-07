/**
 * 题目：https://leetcode-cn.com/problems/minimum-elements-to-add-to-form-a-given-sum/
 * 
 * 构成特定和需要添加的最少元素
 * 
 * 思路
 *      先将数组中的元素求和保存到一个long类型数count中（int可能会溢出）
 *      计算count和目标值的差值的绝对值
 *      然后返回count/abs(limit)或者count/abs(limit)+1即可
 *      
 *      双百快的就不谈
 */
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long count = 0;
        for(int i = 0;i < nums.length;i++){
            count += nums[i];
        }
        count = Math.abs(count - goal);
        if(count == 0) return 0;
        limit =  Math.abs(limit);
        if(count < limit){
            return 1;
        }      
        long ret = count%limit == 0?count/limit:count/limit+1;
        return (int)ret;
    }
}