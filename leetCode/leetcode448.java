/**
 * 题目：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * 
 * 找到数组中消失的数组
 * 
 * 思路
 *      首先对数组进行排序  然后从前往后找，
 *      如果遇到下一个元素减去当前元素不为0 或 1的
 *      把中间相差的部分添加到待返回的List中去
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {   
        List<Integer> ret = new ArrayList<>();
        if(nums.length == 0) return ret;
        Arrays.sort(nums);
        for(int i = 1;i < nums[0];i++){
            ret.add(i);
        }
        for(int i = 0;i < nums.length-1;i++){
            if(!(nums[i+1] - nums[i] == 0||nums[i+1] - nums[i] == 1)){
                for(int j = nums[i]+1;j < nums[i+1];j++){
                    ret.add(j);
                }
            }
        }
        for(int i = nums[nums.length-1]+1;i <= nums.length;i++){
            ret.add(i);
        }
        return ret;
    }
}