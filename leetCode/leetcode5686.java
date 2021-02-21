/**
 * 题目：https://leetcode-cn.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 * 
 * 移动所有球到每个盒子所需的最小操作数
 * 
 * 思路
 *      对每个位置的值就是当前位置到所有值为1的下标差的绝对值之和，每次求和即可
 */
class Solution {
    public int[] minOperations(String boxes) {
        int[] ret = new int[boxes.length()];
        for(int i = 0;i < ret.length;i++){
            for(int j = 0;j < boxes.length();j++){
                if(boxes.charAt(j) == '1'){
                    ret[i] += Math.abs(j-i); 
                }
            }
        }
        return ret;
    }
}