/**
 * 题目：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * 
 * 构建乘积数组
 * 
 * 返回的数组每个位置是除了他之外的所有数的乘积切不能使用除法
 * 
 * 先乘本身左边的数字 （不包括自己）
 * 然后从右向左乘右边的数字（不包括自己）
 * 
 * 妙的就不谈
 */

class Solution {
    public int[] constructArr(int[] a) {
        int[] ret = new int[a.length];
        int n = a.length;
        // ->>
        for(int i = 0,tmp =1;i < n;i++){
            ret[i] = tmp;
            tmp*=a[i];
        }
        // <<-
        for(int i = n-1,tmp =1;i >= 0;i--){
            ret[i] *= tmp;
            tmp*=a[i];
        }
        return ret;
    }
}