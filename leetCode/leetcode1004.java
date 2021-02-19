/**
 * 题目：https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * 
 * 最大连续1的个数III 
 * 
 * 思路
 *      双指针（好像算是滑动窗口）
 *      每次遇到k >= 0进行扩容
 */
public class leetcode1004 {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }
    public static int longestOnes(int[] A, int K) {
        int ret = 0;
        int begin = 0;
        int end = 0;
        while(end < A.length){
            if(A[end] == 1){
                end++;
            }else if(K != 0){
                end++;
                K--;
            }else{
                break;
            }
        }
        ret = end - begin;
        while(end < A.length){
            //进行扩容
            if(K >= 0){
                while(end < A.length){
                    if(A[end] == 1){
                        end++;
                    }else if(K != 0){
                        end++;
                        K--;
                    }else{
                        break;
                    }
                }
                ret = end - begin;
            }
            if(A[begin] == 0){
                K++;
            }
            if(A.length > end && A[end] == 0) {
                K--;
            }
            end++;
            begin++;
        }
        return ret;
    }
}