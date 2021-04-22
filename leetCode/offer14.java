/**
 * 题目：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * 
 * 剪绳子 II
 * 
 * 思路：采用贪心的思想
 *  当 n >= 5时必定有：
 *      1. 3*(n-3) > n
 *      2. 2*(n-2) > n
 *      且：
 *      3*(n-3) > 2*(n-2)  当剩余为4时：2*2 > 1*3
 * 
 *      即可推出以下代码
 *          但是：Math.pow()函数还是会溢出 就只能循环的乘了然后及时取余数
 * 
 */

class Solution {
    public int cuttingRope(int n) {
        //n < 5的 （4的在下面算了）
        int[] ret = new int[4];
        ret[2] = 1;
        ret[3] = 2;
        if(n < 4) return ret[n];
        long res = 1;
        int n3 = n/3;
        //剩下1则可以组成一个4
        if(n-(n3*3) == 1){
            n3-=1;
        }
        int n2 = (n-n3*3)/2;
        while(n3 != 0){
            res = ((res%(1000000007))*3)%1000000007;
            n3--;
        }
        while(n2 != 0){
            res = ((res%(1000000007))*2)%1000000007;
            n2--;
        }
        return (int)res%(1000000007);
    }
}