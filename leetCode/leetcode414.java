/**
 * 题目：https://leetcode-cn.com/problems/third-maximum-number/
 * 
 * 第三大的数字
 * 
 * 思路
 *      定义long类型的三个数 max min mid 取值为int最小值减一
 *      依次进行比较 然后修改 最后按条件返回
 */
class Solution {
    public int thirdMax(int[] nums) {
        long min = -2147483649l;
        long mid = -2147483649l;
        long max = -2147483649l;
        for(int i : nums){
            if(i >= max){
                if(i == max) continue;
                min = mid;
                mid = max;
                max = i;
            }else if(i >= mid){
                if(i == mid) continue;
                min = mid;
                mid = i;
            }else if(i >= min){
                if(i == min) continue;
                min = i;
            }
        }
        return min == -2147483649l?(int)max:(int)min;
    }
}