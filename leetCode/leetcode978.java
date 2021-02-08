/**
 * 题目：https://leetcode-cn.com/problems/longest-turbulent-subarray/
 * 
 * 最长湍流子数组
 * 思路：
 *      维护一个长度区间，判断这个长度内的子数组是否为满足条件的
 *      如果满足，向后扩张到不满足
 *      保存最大长度即可
 */
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 0||arr.length == 1) return arr.length;
        int start = 0;
        int end = 1;
        int len = 0;
        int ret = 1;
        int flag = 0;
        while(end < arr.length){
            if(isTu(start,end,arr)){
                while(end < arr.length&&isTu(start,end,arr)){   
                    end++;
                }
                len = end - start;
                start += (len-1);
                end += (len-1);
                ret = Math.max(ret,len);
            }else{
                end++;
                start++;
            } 
        }
        return ret;
    }
    public static boolean isTu(int start,int end,int[] arr){
        int flag;
        if(arr[start+1] > arr[start]){
            flag = 1;
        }else if(arr[start+1] < arr[start]){
            flag = -1;
        }else{
            flag = 0;
        }
        for(int i = start+2;i <= end;i++){
            if(flag == 1){
                if(arr[i] >= arr[i-1]){
                    return false;
                }else{
                    flag = -1;
                }   
            }
            else if(flag == -1){
                if(arr[i] <=   arr[i-1]){
                return false;
                }else{
                    flag = 1;
                } 
            }else{
                return false;
            }
        }   
        if(flag == 0){
            return false;
        }
        return true;
    }
}