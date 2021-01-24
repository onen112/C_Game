/**
 * 题目：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 *  最长连续增长序列
 */
public class leetcode674 {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1,2}));
    }
    public static int findLengthOfLCIS(int[] nums) {
        int s = 0;
        int max = 0;
        int ins = 1;
        if(nums.length == 0||nums.length == 1){
            return nums.length;
        }
        while(s < nums.length-1){
            while(s+1 < nums.length&&nums[s] < nums[s+1]){
                ins++;
                s++;
            }
            max = max<ins?ins:max;
            ins = 1;
            s++;
        }
        return max;
    }
}