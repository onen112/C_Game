/**
 * 题目：https://leetcode-cn.com/problems/chou-shu-lcof/
 * 
 * 丑数
 * 
 * 思路：
 *      每个丑数都是由前一个丑数*2或者*3或*5得到对 
 *      所以我们只需要保证所获取的是按照大小顺序的丑数
 *      就能得到第n个丑数
 */
class Solution {
    public int nthUglyNumber(int n) {
        if(n == 0) return 0;
        int[] nums = new int[n];
        nums[0] = 1;
        int index = 1;
        int m2 = 1;
        int m3 = 1;
        int m5 = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while(index < n){
            int min = min_(m2*2,m3*3,m5*5);
            //当前丑数为这几个能得到的最小值
            nums[index] = min;

            while(m2*2 <= min){
                m2 = nums[++index2];
            }
            while(m3 * 3 <= min){
                m3 = nums[++index3];
            }
            while(m5*5 <= min){
                m5 = nums[++index5];
            }
            index++;
        }
        return nums[n-1];
    }
    public int min_(int n1,int n2,int n3){
        n1 = Math.min(n1,n2);
        return  Math.min(n1,n3);
    }
}