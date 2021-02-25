/**
 * 题目：https://leetcode-cn.com/problems/reverse-only-letters/
 * 
 * 仅仅反转字母
 * 
 * 思路
 *      定义两个下标 一个从前往后 一个从后往前 遇到两边都是字母
 *      交换两者的值否则继续找
 */
class Solution {
    public String reverseOnlyLetters(String S) {
       char[] chars = S.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while(left < right){
        while(left < chars.length && ((chars[left] < 'A' || chars[left] > 'Z') && (chars[left] < 'a' || chars[left] > 'z'))){
                left++;
            }
            if(left >= right) break;
            while(right >= 0 && ((chars[right] < 'A' || chars[right] > 'Z') && (chars[right] < 'a' || chars[right] > 'z')))
            {
                right--;
            }
            if(left >= right) break;
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;

            left++;
            right--;
        }
        return new String(chars);
    }
}