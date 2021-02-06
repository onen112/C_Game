/**
 * 题目：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 * 
 * 可获得的最大数
 * 
 * 思路：
 *      创建两个长度为k的数组存放分数
 *      一个0-k另一个从len-k到len
 *      里面存放从一侧取到该位置可以获得的总分数
 * 
 *      返回得分最大的得分即可
 * 
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
       int len = cardPoints.length;
       int[] cardl = Arrays.copyOfRange(cardPoints,0,k);
       int[] cardr = Arrays.copyOfRange(cardPoints, len-k,len);
   
       for(int i = 1;i < cardl.length;i++){
           cardl[i] += cardl[i-1];
           cardr[cardr.length-i-1] += cardr[cardr.length-i];
       }
       int ret = cardl[k-1];
       int i = k-2;
       int max = 0;

       while(i >= 0){
           max = cardl[i] + cardr[cardr.length - (k - i - 1)];
           ret = Math.max(max,ret);
           i--;
       }
       ret = Math.max(ret,cardr[0]);
       return ret;
   }
}