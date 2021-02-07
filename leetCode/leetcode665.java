/**
 * 题目：https://leetcode-cn.com/problems/non-decreasing-array/
 * 
 * 非递减数列
 * 
 * 思路：
 *      每次修改一个不是递增的元素，然后判断修改后的序列是否有序
 *      如果不是就返回false
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        int c = 1;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] < nums[i-1]){
                if(c == 0){
                    return false;
                }
                int tmp = nums[i];
                nums[i] = nums[i-1];
                c--;
                if(check(nums)){
                    return true;
                }else{
                    nums[i] = tmp;
                    nums[i-1] = tmp;
                    return check(nums);
                }
            }
        }
        return true;
    }
    public boolean check(int[] nums){
        for(int i = 1;i < nums.length;i++){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }
        return true;
    }
}