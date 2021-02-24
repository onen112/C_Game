/**
 * 题目：https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 * 
 * 爱生气的书店老板
 * 
 * 思路
 *      先求出不抑制情绪时客户的满意度 max
 *      然后定义一个left 一个right 向后走
 *      长度为持续时间 X 其中遇到不满意的 也加到max上
 *      然后left right同时向后走 
 *      right遇到不满意（grumpy[right] == 0）max 加上 customers[right]
 *      grumpy[left] == 0 max 减去 customers[left]
 *      更新ret 直到right走到最后
 */
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ret = 0;
        int max = 0;
        for(int i = 0;i < customers.length;i++){
            if(grumpy[i] == 0){
                max += customers[i];
            }
        }
        int left = 0;
        int right = 0;
        while(right < X){
            if(grumpy[right] == 1){
                max += customers[right];
            }
            right++;
        }
        ret = max;
        while(right < grumpy.length){
            if(grumpy[right] == 1){
                max += customers[right];
            }
            if(grumpy[left] == 1){
                max -= customers[left];
            }
            ret = Math.max(ret,max);
            left++;
            right++;
        }    
        return ret;
    }
}