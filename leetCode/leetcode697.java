/**
 * 题目：https://leetcode-cn.com/problems/degree-of-an-array/
 * 
 * 数组的度
 * 
 * 思路
 *      先用打表法保存每个元素出现的次数
 *      然后去找子数组中出现次数最多的数组的长度
 *      进行比较即可
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] num = new int[500005];
        int max = 0;
        int get = 0;
        for(int i : nums){
            num[i]++;
            max = Math.max(max,num[i]);
        }
        int left = 0;
        int right = nums.length-1;
        int ret = nums.length;
        while(left < nums.length){
            if(num[nums[left]] == max){
                right = nums.length-1;
                while(right >= left){
                    if(nums[right] == nums[left]){
                        ret = Math.min(ret,right-left+1);
                        num[nums[left]] = 0;
                        break;
                    }
                    right--;
                }
            }
            left++;
        }
        return ret;
    }
}
