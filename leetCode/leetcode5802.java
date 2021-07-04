/**
 * 题目：https://leetcode-cn.com/problems/count-good-numbers/
 * 
 * 统计好数字的数目
 * 
 * 快速幂运算
 * 
 */
class Solution {
    public static final long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        return (int)((fastPow(5,(n+1)/2) * fastPow(4,n/2) )%MOD);
    }
    public long fastPow(long x,long n){
        long res = 1;
        while(n > 0){
            if(n%2 == 1) res = (res*x)%MOD;
            x=(x*x)%MOD;
            n/=2;
        }
        return res;
    }
}